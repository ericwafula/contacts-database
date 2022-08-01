package tech.ericwathome.contactsdatabase.exception

import org.springframework.http.HttpStatus

class ErrorMessage(
    val status: HttpStatus,
    val message: String?
)