package tn.droidzed.ktoury.dtos

data class AuthResponse(
    val accessToken: String? = null,
    val refreshToken: String? = null,
    val error: String? = null,
)
