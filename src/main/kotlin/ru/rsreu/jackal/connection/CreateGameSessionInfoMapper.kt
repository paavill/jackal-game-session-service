package ru.rsreu.jackal.connection

import org.springframework.stereotype.Component
import ru.rsreu.jackal.configuration.WebSocketUrlConfiguration
import ru.rsreu.jackal.shared_models.CreateGameSessionResponse
import ru.rsreu.jackal.shared_models.HttpResponseStatus
import ru.rsreu.jackal.shared_models.PlayerInfo
import ru.rsreu.jackal.shared_models.WebSocketInfo
import java.util.*

@Component
class CreateGameSessionInfoMapper(val webSocketUrlConfiguration: WebSocketUrlConfiguration) {

    fun map(info: SessionCreationInformation): CreateGameSessionResponse {
        val userInfos = info.usersJwt.map { (id, jwt) ->
            PlayerInfo(
                id,
                jwt,
                with(webSocketUrlConfiguration) {
                    WebSocketInfo(
                        receiving + info.sessionId,
                        receivingPersonal + info.sessionId
                    )
                })

        }
        return CreateGameSessionResponse(userInfos, Date(), HttpResponseStatus.OK)
    }

}