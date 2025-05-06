package tn.droidzed.ktoury.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/profile")
class ProfileController {

    @GetMapping("/{userId}")
    fun index(@PathVariable userId: String, model: Model): String {
        model.addAttribute("username", userId)
        return "profile"
    }
}
