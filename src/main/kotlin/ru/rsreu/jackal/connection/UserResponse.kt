package ru.rsreu.jackal.connection

// TODO: 19.07.2022 Создать тип для WebSocketInfo
data class UserResponse(val userId: Long, val jwt: String, val webSocketInfo: List<String>)