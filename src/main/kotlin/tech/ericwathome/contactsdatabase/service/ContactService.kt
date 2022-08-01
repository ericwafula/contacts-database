package tech.ericwathome.contactsdatabase.service

import tech.ericwathome.contactsdatabase.dto.ContactDto

interface ContactService {
    fun addContact(contactDto: ContactDto)
}