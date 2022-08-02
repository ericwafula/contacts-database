package tech.ericwathome.contactsdatabase.exception

import org.springframework.http.HttpStatus

data class ErrorMessage(
    val status: HttpStatus,
    val message: String?
)