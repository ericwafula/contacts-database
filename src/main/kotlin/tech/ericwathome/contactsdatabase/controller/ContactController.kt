package tech.ericwathome.contactsdatabase.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.ericwathome.contactsdatabase.service.ContactService

@RestController
@RequestMapping("api/v1/contacts")
class ContactController(
    private val contactService: ContactService
) {

}