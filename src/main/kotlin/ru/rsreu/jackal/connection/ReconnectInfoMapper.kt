package ru.rsreu.jackal.connection

import org.springframework.stereotype.Component
import ru.rsreu.jackal.configuration.WebSocketUrlConfiguration
import ru.rsreu.jackal.shared_models.HttpResponseStatus
import ru.rsreu.jackal.shared_models.PlayerInfo
import ru.rsreu.jackal.shared_models.ReconnectGameSessionResponse
import ru.rsreu.jackal.shared_models.WebSocketInfo
import java.util.*

@Component
class ReconnectInfoMapper(val webSocketUrlConfiguration: WebSocketUrlConfiguration) {

    fun map(info: ReconnectionInformation): ReconnectGameSessionResponse {

        val userInfo = PlayerInfo(
            info.userId,
            info.jwt,
            with(webSocketUrlConfiguration) {
                WebSocketInfo(
                    receiving + info.sessionId,
                    receivingPersonal + info.sessionId
                )
            })

        return ReconnectGameSessionResponse(userInfo, HttpResponseStatus.OK)
    }

}