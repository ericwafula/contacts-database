package tech.ericwathome.contactsdatabase.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import tech.ericwathome.contactsdatabase.dto.ContactDto
import tech.ericwathome.contactsdatabase.dto.ResponseMessage
import tech.ericwathome.contactsdatabase.entity.Contact
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

    @GetMapping
    fun allContacts(): ResponseEntity<List<Contact>> {
        return ResponseEntity(contactService.allContacts(), HttpStatus.OK)
    }

    @GetMapping("contact")
    fun findContact(@RequestParam("id") id: Long) : ResponseEntity<Contact> {
        return ResponseEntity(contactService.findContact(id), HttpStatus.OK)
    }

    @GetMapping("tel")
    fun findContactByPhoneNumber(@RequestParam("number") phoneNumber: String): ResponseEntity<List<Contact>> {
        return ResponseEntity(contactService.findContactByPhoneNumber(phoneNumber), HttpStatus.OK)
    }

    @PatchMapping("contact/update")
    fun updateContact(@RequestParam("id") id: Long, @RequestBody contactDto: ContactDto): ResponseEntity<ResponseMessage> {
        contactService.updateContact(id, contactDto)
        val message = ResponseMessage("contact updated successfully")
        return ResponseEntity(message, HttpStatus.OK)
    }

    @DeleteMapping("contact/delete")
    fun deleteContact(@RequestParam("id") id: Long): ResponseEntity<ResponseMessage> {
        contactService.deleteContact(id)
        val message = ResponseMessage("contact deleted successfully")
        return ResponseEntity(message, HttpStatus.OK)
    }
}