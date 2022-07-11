package ru.rsreu.jackal

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SessionCreationController(private val sessionService: SessionService){
    @CrossOrigin
    @GetMapping("/create-new")
    fun createNewSession(@RequestParam id: String) : ResponseEntity<String> {
        sessionService.createNewSession(id)
        println(sessionService.getSessionsNumber())
        return ResponseEntity<String>("ok", HttpStatus.OK)
    }
}