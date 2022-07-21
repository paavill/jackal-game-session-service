package ru.rsreu.jackal.shared_models

data class ReconnectGameSessionResponse(
    val playerInfo: PlayerInfo,
    override val responseStatus: HttpResponseStatus
) : HttpResponse(responseStatus)

data class PlayerInfo(
    val userId: Long, val jwt: String, val webSocketInfo: WebSocketInfo
)