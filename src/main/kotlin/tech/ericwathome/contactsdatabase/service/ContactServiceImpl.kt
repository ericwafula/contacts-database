package tech.ericwathome.contactsdatabase.service

import org.springframework.stereotype.Service
import tech.ericwathome.contactsdatabase.dto.ContactDto
import tech.ericwathome.contactsdatabase.entity.Contact
import tech.ericwathome.contactsdatabase.exception.EntityAlreadyExistsException
import tech.ericwathome.contactsdatabase.repository.ContactRepository

@Service
class ContactServiceImpl(
    private val contactRepository: ContactRepository
) : ContactService {
    override fun addContact(contactDto: ContactDto) {
        val existingContact = contactRepository.findContactByPhoneNumber(contactDto.phoneNumber)
        if (existingContact.isPresent) throw EntityAlreadyExistsException("USER_WITH_PHONE_NUMBER_ALREADY_EXISTS")
        contactRepository.save(Contact(
            firstName = contactDto.firstName,
            lastName = contactDto.lastName,
            phoneNumber = contactDto.phoneNumber,
            location = contactDto.location
        ))
    }
}