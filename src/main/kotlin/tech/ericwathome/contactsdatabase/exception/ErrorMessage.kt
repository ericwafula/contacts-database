package tech.ericwathome.contactsdatabase.exception

import org.springframework.web.bind.annotation.ResponseStatus

class ErrorMessage(
    val status: ResponseStatus,
    val message: String
)