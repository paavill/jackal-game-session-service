package ru.rsreu.jackal.shared_models

import java.util.*

data class CreateGameSessionResponse(
    val playerInfos: Collection<PlayerInfo>,
    val startDate: Date,
    override val responseStatus: HttpResponseStatus
) : HttpResponse(responseStatus)

data class PlayerInfo(
    val userId: Long, val jwt: String, val webSocketInfo: WebSocketInfo
)