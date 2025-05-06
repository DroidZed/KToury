package tn.droidzed.ktoury.controllers

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.stereotype.Controller
import tn.droidzed.ktoury.dtos.ApiResponse
import tn.droidzed.ktoury.dtos.AuthResponse
import tn.droidzed.ktoury.dtos.LoginBody
import tn.droidzed.ktoury.dtos.RegisterDto

@Controller
class AuthController {

    @MutationMapping
    fun login(@Argument body: LoginBody): AuthResponse {
        return AuthResponse("access", "refresh", "error")
    }

    @MutationMapping
    fun register(@Argument body: RegisterDto): ApiResponse {
        return ApiResponse("message", "error")
    }
}
