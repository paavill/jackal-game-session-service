package ru.rsreu.jackal.connection

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.rsreu.jackal.connection.connection_checker.SessionConnectionChecker

@RestController
class SessionCreationController(
    private val sessionService: SessionService,
    private val connectionChecker: SessionConnectionChecker
) {
    @CrossOrigin
    @PostMapping(value = ["/create-new"], consumes = ["application/json"], produces = ["application/json"])
    fun createNewSession(@RequestBody sessionCreationRequest: SessionCreationRequest): ResponseEntity<SessionCreationResponse> {
        val response = sessionService.createNewSession(sessionCreationRequest)
        connectionChecker.addCheckConnectionTask(sessionService.getSessionById(response.sessionId))
        println("Number of sessions: " + sessionService.getSessionsNumber())
        return ResponseEntity<SessionCreationResponse>(response, HttpStatus.OK)
    }
}