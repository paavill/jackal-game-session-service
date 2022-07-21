package ru.rsreu.jackal.connection

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.rsreu.jackal.connection.connection_checker.SessionConnectionChecker
import ru.rsreu.jackal.shared_models.CreateGameSessionResponse
import ru.rsreu.jackal.shared_models.HttpResponseStatus
import ru.rsreu.jackal.shared_models.ReconnectGameSessionResponse
import java.util.*

@RestController
class SessionCreationController(
    private val sessionService: SessionService,
    private val connectionChecker: SessionConnectionChecker,
    private val reconnectInfoMapper: ReconnectInfoMapper
) {
    @CrossOrigin
    @PostMapping(value = ["/create-new"], consumes = ["application/json"])
    fun createNewSession(@RequestBody sessionCreationRequest: SessionCreationRequest): ResponseEntity<CreateGameSessionResponse> {
        val information = sessionService.createNewSession(sessionCreationRequest)
        connectionChecker.addCheckConnectionTask(sessionService.getSessionById(information))
        println("Number of sessions: " + sessionService.getSessionsNumber())
        return ResponseEntity.ok(CreateGameSessionResponse(Date(), HttpResponseStatus.OK))
    }

    @CrossOrigin
    @GetMapping(value = ["/reconnect"], produces = ["application/json"])
    fun reconnect(@RequestParam userId: Long): ResponseEntity<ReconnectGameSessionResponse> {
        val info = sessionService.getReconnectInfoByUserId(userId)
        return ResponseEntity.ok(reconnectInfoMapper.map(info))
    }
}