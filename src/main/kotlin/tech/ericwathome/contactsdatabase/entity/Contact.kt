package tech.ericwathome.contactsdatabase.entity

import org.hibernate.Hibernate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Contact(
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id val id: Long? = null,
    var firstName: String,
    var lastName: String,
    var address: String,
    var phoneNumber: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Contact

        return id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , firstName = $firstName , lastName = $lastName , location = $address , phoneNumber = $phoneNumber )"
    }
}