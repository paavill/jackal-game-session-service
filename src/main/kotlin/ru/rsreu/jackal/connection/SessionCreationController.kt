package ru.rsreu.jackal.connection

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SessionCreationController(private val sessionService: SessionService){
    @CrossOrigin
    @PostMapping(value = ["/create-new"], consumes = ["application/json"], produces = ["application/json"])
    fun createNewSession(@RequestBody sessionCreationRequest: SessionCreationRequest) : ResponseEntity<String> {
        val uuid = sessionService.createNewSession(sessionCreationRequest)
        println("Number of sessions: " + sessionService.getSessionsNumber())
        return ResponseEntity<String>(uuid, HttpStatus.OK)
    }
}