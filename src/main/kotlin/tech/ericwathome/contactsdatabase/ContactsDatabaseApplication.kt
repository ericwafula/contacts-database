package tech.ericwathome.contactsdatabase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ContactsDatabaseApplication

fun main(args: Array<String>) {
    runApplication<ContactsDatabaseApplication>(*args)
}
