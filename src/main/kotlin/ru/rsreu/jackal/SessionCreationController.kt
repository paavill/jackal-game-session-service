package ru.rsreu.jackal

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class SessionCreationController(private val sessionService: SessionService){
    @CrossOrigin
    @PostMapping(value = ["/create-new"], consumes = ["application/json"], produces = ["application/json"])
    fun createNewSession(@RequestBody sessionCreationRequest: SessionCreationRequest) : ResponseEntity<String> {
        sessionService.createNewSession(sessionCreationRequest.sessionId)
        println("Number of sessions: " + sessionService.getSessionsNumber())
        return ResponseEntity<String>("ok", HttpStatus.OK)
    }
}