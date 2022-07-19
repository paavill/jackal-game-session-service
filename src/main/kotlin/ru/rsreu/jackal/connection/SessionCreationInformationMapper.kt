package ru.rsreu.jackal.connection

import org.springframework.stereotype.Component
import ru.rsreu.jackal.configuration.WebSocketUrlConfiguration
import java.util.Date

@Component
class SessionCreationInformationMapper(val webSocketUrlConfiguration: WebSocketUrlConfiguration) {

    fun map(info: SessionCreationInformation): SessionCreationInformationResponse {
        val sessionUrls = listOf(
            webSocketUrlConfiguration.sendingPattern + info.sessionId,
            webSocketUrlConfiguration.receiving + info.sessionId,
            webSocketUrlConfiguration.receivingPersonal + info.sessionId
        )
        val usersResponse = info.usersJwt.map { (id, jwt) ->
            UserResponse(id, jwt, sessionUrls)
        }
        return SessionCreationInformationResponse(usersResponse, Date(), "")
    }

}