package ru.rsreu.jackal.connection

data class ReconnectionInformation(val userId: Long, val sessionId: String, val jwt: String)