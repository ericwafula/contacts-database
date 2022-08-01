package tech.ericwathome.contactsdatabase.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tech.ericwathome.contactsdatabase.dto.ContactDto
import tech.ericwathome.contactsdatabase.dto.ResponseMessage
import tech.ericwathome.contactsdatabase.service.ContactService

@RestController
@RequestMapping("api/v1/contacts")
class ContactController(
    private val contactService: ContactService
) {
    @PostMapping("new")
    fun addContact(@RequestBody contactDto: ContactDto): ResponseEntity<ResponseMessage> {
        contactService.addContact(contactDto)
        val message = ResponseMessage("contact added successfully")
        return ResponseEntity(message, HttpStatus.OK)
    }
}