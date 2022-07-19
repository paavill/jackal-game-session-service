package ru.rsreu.jackal.connection.connection_checker

import ru.rsreu.jackal.websocket.dto.WebsocketResponseType

class GameNotStartedWsResponse(
    val websocketResponseType: WebsocketResponseType = WebsocketResponseType.GAME_NOT_START_INFO_FOR_ALL,
    val notConnectedUserIds: List<Long>
)