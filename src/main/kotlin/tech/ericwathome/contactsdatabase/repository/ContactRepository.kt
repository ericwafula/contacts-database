package tech.ericwathome.contactsdatabase.repository

import org.springframework.data.jpa.repository.JpaRepository
import tech.ericwathome.contactsdatabase.entity.Contact
import java.util.Optional

interface ContactRepository : JpaRepository<Contact, Long> {
    fun findContactByPhoneNumber(phoneNumber: String): Optional<Contact>
}