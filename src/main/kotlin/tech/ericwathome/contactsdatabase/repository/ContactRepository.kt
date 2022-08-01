package tech.ericwathome.contactsdatabase.repository

import org.springframework.data.jpa.repository.JpaRepository
import tech.ericwathome.contactsdatabase.entity.Contact

interface ContactRepository : JpaRepository<Contact, Long> {
}