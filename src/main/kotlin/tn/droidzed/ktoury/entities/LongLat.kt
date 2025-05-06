package tn.droidzed.ktoury.entities

import jakarta.persistence.Embeddable

@Embeddable
data class LongLat(
    var longitude: Double = 0.0,
    var latitude: Double = 0.0
)
