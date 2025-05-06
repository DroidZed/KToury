package tn.droidzed.ktoury.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "user_id")
    var id: Long? = null,

    var fullName: String = "",

    var email: String = "",

    var password: String = "",

    var picture: String = "",

    @Enumerated(EnumType.ORDINAL)
    var role: UserRole = UserRole.CLIENT,

    @OneToOne(
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY
    )
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    var address: Address? = null,
) {
    override fun toString(): String =
        "User(role=$role, picture='$picture', password='$password', email='$email', fullName='$fullName', id=$id)"

    override fun hashCode(): Int = javaClass.hashCode()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (id != other.id) return false
        if (fullName != other.fullName) return false
        if (email != other.email) return false
        if (password != other.password) return false
        if (picture != other.picture) return false
        if (role != other.role) return false
        if (address != other.address) return false

        return true
    }
}
