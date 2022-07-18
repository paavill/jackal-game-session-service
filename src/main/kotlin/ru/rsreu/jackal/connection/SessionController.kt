package ru.rsreu.jackal.connection

import org.springframework.messaging.Message
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.stereotype.Controller
import ru.rsreu.jackal.game.*
import ru.rsreu.jackal.game.dto.CellResponse
import ru.rsreu.jackal.game.dto.GameApplyActionMapper
import ru.rsreu.jackal.game.dto.GameStateMapper
import ru.rsreu.jackal.game.dto.InitDataResponse

@Controller
class SessionController(val sessionService: SessionService,
                        val gameService: GameService,
                        val gameStateMapper: GameStateMapper,
                        val gameApplyActionMapper: GameApplyActionMapper,
                        val simpMessagingTemplate: SimpMessagingTemplate
) {
    @MessageMapping("/action/{id}")
    @SendTo("/jackal-broker/action-result/{id}")
    fun gameActionMessageHandler(@DestinationVariable("id") id: String,
                                 @Payload message: Action,
                                 principal: PreAuthenticatedAuthenticationToken): List<CellResponse> {
        sessionService.validateOrThrow(principal)
        val session = sessionService.getSessionById(id)
        val game = gameService.getGameBySession(session)
        val seq = game.applyAction(message)
        return gameApplyActionMapper.map(seq)
    }

    @MessageMapping("/init-data/{id}")
    @SendTo("/jackal-broker/init-result/{id}")
    fun initMessageHandler(@DestinationVariable("id") id: String,
                           @Payload message: Message<*>,
                           principal: PreAuthenticatedAuthenticationToken) : String {
        sessionService.validateOrThrow(principal)
        val session = sessionService.getSessionById(id)
        val newGame = gameService.createNewOrReturnExistingGameBySession(session)
        simpMessagingTemplate.convertAndSendToUser(principal.principal.toString(),
            "/jackal-broker/init-result/$id", gameStateMapper.map(newGame))
        return "Player ${principal.principal} connected"
    }
}