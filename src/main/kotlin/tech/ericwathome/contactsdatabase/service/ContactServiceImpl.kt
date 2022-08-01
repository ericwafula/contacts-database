package tech.ericwathome.contactsdatabase.service

import org.springframework.stereotype.Service
import tech.ericwathome.contactsdatabase.repository.ContactRepository

@Service
class ContactServiceImpl(
    private val contactRepository: ContactRepository
) : ContactService {
}