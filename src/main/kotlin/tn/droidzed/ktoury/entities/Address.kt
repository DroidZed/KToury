package tn.droidzed.ktoury.entities

import jakarta.persistence.*

@Entity
@Table(name = "addresses")
class Address(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
        nullable = false,
        name = "address_id"
    ) var id: Long? = null,

    var city: String = "",
    var street: String = "",
    var houseNumber: String = "",
    var postalCode: String = "",
    var state: String = "",

    @Embedded var location: LongLat? = null,
    var country: String = "",

    @OneToOne(
        mappedBy = "address",
    )
    var owner: User,
) {

    override fun toString(): String =
        "Address(id=$id, city='$city', street='$street', houseNumber='$houseNumber', postalCode='$postalCode', state='$state', country='$country')"

    override fun hashCode(): Int = javaClass.hashCode()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Address) return false

        if (id != other.id) return false
        if (city != other.city) return false
        if (street != other.street) return false
        if (houseNumber != other.houseNumber) return false
        if (postalCode != other.postalCode) return false
        if (state != other.state) return false
        if (location != other.location) return false
        if (country != other.country) return false

        return true
    }
}
