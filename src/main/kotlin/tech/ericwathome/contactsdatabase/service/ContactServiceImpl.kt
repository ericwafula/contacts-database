package tech.ericwathome.contactsdatabase.service

import org.springframework.stereotype.Service
import tech.ericwathome.contactsdatabase.dto.ContactDto
import tech.ericwathome.contactsdatabase.entity.Contact
import tech.ericwathome.contactsdatabase.exception.EntityAlreadyExistsException
import tech.ericwathome.contactsdatabase.repository.ContactRepository
import javax.persistence.EntityNotFoundException

@Service
class ContactServiceImpl(
    private val contactRepository: ContactRepository
) : ContactService {
    override fun addContact(contactDto: ContactDto) {
        val contacts = contactRepository.findContactByPhoneNumberContains(contactDto.phoneNumber)
        contacts.binarySearch { contact ->
            if (contact.phoneNumber == contactDto.phoneNumber) throw EntityAlreadyExistsException("USER_ALREADY_FOUND_WITH_PHONE_NUMBER: ${contactDto.phoneNumber}")
            0
        }

        contactRepository.save(
            Contact(
                firstName = contactDto.firstName,
                lastName = contactDto.lastName,
                phoneNumber = contactDto.phoneNumber,
                address = contactDto.address
            )
        )
    }

    override fun allContacts(): List<Contact> {
        return contactRepository.findAll()
    }

    override fun findContact(id: Long): Contact {
        val contact = contactRepository.findById(id)
        contact.orElseThrow { EntityNotFoundException("NO_USER_FOUND_WITH_ID: $id") }
        return contact.get()
    }

    override fun findContactByPhoneNumber(phoneNumber: String): List<Contact> {
        return contactRepository.findContactByPhoneNumberContains(phoneNumber)
    }

    override fun updateContact(id: Long, contactDto: ContactDto) {
        val contact = contactRepository.findById(id)
        contact.orElseThrow { EntityNotFoundException("NO_CONTACT_FOUND_WITH_ID: $id") }
        if (contactDto.firstName.isNotBlank()) contact.get().firstName = contactDto.firstName
        if (contactDto.lastName.isNotBlank()) contact.get().lastName = contactDto.lastName
        if (contactDto.address.isNotBlank()) contact.get().address = contactDto.address
        if (contactDto.phoneNumber.isNotBlank()) contact.get().phoneNumber = contactDto.phoneNumber
        contactRepository.save(contact.get())
    }

    override fun deleteContact(id: Long) {
        val contact = contactRepository.findById(id)
        contact.orElseThrow { EntityNotFoundException("NO_CONTACT_FOUND_WITH_ID: $id") }
        contactRepository.deleteById(id)
    }
}