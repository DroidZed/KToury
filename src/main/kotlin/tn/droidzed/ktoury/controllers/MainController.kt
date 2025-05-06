package tn.droidzed.ktoury.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class MainController {

    @GetMapping("/")
    fun index(): ResponseEntity<Map<String, String>> {
        return mapOf("message" to "Hello World").let { ResponseEntity.ok(it) }
    }
}
