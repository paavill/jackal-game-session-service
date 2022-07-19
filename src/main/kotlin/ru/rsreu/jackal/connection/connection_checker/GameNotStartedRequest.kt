package ru.rsreu.jackal.connection.connection_checker

data class GameNotStartedRequest(val lobbyId: String, val notConnectedUserIds: List<Long>)