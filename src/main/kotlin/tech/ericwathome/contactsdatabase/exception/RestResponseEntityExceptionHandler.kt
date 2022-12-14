package tech.ericwathome.contactsdatabase.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.persistence.EntityNotFoundException

@ControllerAdvice
@ResponseStatus
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler(EntityAlreadyExistsException::class)
    fun entityAlreadyExistsException(exception: EntityAlreadyExistsException, request: WebRequest): ResponseEntity<ErrorMessage> {
        val message = ErrorMessage(HttpStatus.BAD_REQUEST, exception.message)
        return ResponseEntity(message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(EntityNotFoundException::class)
    fun entityNotFoundException(exception: EntityNotFoundException, request: WebRequest): ResponseEntity<ErrorMessage> {
        val message = ErrorMessage(HttpStatus.NOT_FOUND, exception.message)
        return ResponseEntity(message, HttpStatus.NOT_FOUND)
    }
}