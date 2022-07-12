package ru.rsreu.jackal.connection

import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import ru.rsreu.jackal.game.Action
import ru.rsreu.jackal.game.Game
import ru.rsreu.jackal.game.GameService

@Controller
class SessionController(private val sessionService: SessionService, val gameService: GameService) {
    @MessageMapping("/action/{id}")
    @SendTo("/jackal-broker/action-result/{id}")
    fun gameActionMessageHandler(@DestinationVariable("id") id: String, @Payload message: Action, @Header("jwt_token") token: String): String {
        sessionService.valideOrThrow(token)
        val session = sessionService.getSessionById(id)
        val game = gameService.getGameBySession(session)
        game.applyAction("", message)
        return "Hello " + sessionService.getSessionById(id).id
    }

    @MessageMapping("/init-data/{id}")
    @SendTo("/jackal-broker/init-result/{id}")
    fun initMessageHandler(@DestinationVariable("id") id: String, @Header("jwt_token") token: String) : Game {
        sessionService.valideOrThrow(token)
        val session = sessionService.getSessionById(id)
        return gameService.createNew(session)
    }
}