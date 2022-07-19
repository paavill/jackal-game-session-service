package ru.rsreu.jackal.connection

data class SessionCreationInformation(
    val sessionId: String,
    val usersJwt: Map<Long, String>
)