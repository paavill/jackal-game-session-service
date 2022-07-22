package ru.rsreu.jackal.connection

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.rsreu.jackal.connection.connection_checker.SessionConnectionChecker
import ru.rsreu.jackal.shared_models.CreateGameSessionResponse
import javax.validation.Valid

@RestController
class SessionCreationController(
    private val sessionService: SessionService,
    private val connectionChecker: SessionConnectionChecker,
    private val createGameSessionInfoMapper: CreateGameSessionInfoMapper
) {
    @CrossOrigin
    @PostMapping(value = ["/create-new"], consumes = ["application/json"], produces = ["application/json"])
    fun createNewSession(@Valid @RequestBody sessionCreationRequest: SessionCreationRequest): ResponseEntity<CreateGameSessionResponse> {
        val information = sessionService.createNewSession(sessionCreationRequest)
        connectionChecker.addCheckConnectionTask(sessionService.getSessionById(information.sessionId))
        println("Number of sessions: " + sessionService.getSessionsNumber())
        return ResponseEntity.ok(createGameSessionInfoMapper.map(information))
    }
}