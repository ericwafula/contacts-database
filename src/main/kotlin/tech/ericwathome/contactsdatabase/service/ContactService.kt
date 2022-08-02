package tech.ericwathome.contactsdatabase.service

import tech.ericwathome.contactsdatabase.dto.ContactDto
import tech.ericwathome.contactsdatabase.entity.Contact

interface ContactService {
    fun addContact(contactDto: ContactDto)
    fun allContacts(): List<Contact>
    fun findContact(id: Long): Contact
    fun findContactByPhoneNumber(phoneNumber: String): List<Contact>
    fun updateContact(id: Long, contactDto: ContactDto)
    fun deleteContact(id: Long)
}