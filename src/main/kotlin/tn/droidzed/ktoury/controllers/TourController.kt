package tn.droidzed.ktoury.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/tours")
class TourController {

    @GetMapping("/")
    fun index(): String {
        return "tours/index"
    }
}
