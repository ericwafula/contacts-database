package tech.ericwathome.contactsdatabase.exception

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
@ResponseStatus
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

}