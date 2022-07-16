package ru.rsreu.jackal.connection

data class SessionCreationResponse(
    val sessionId: String,
    val usersJwt: Map<String, String>)