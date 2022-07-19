package ru.rsreu.jackal.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class WebSocketUrlConfiguration(
    @Value("\${websocket.url_pattern.sending}") val sendingPattern: String,
    @Value("\${websocket.url_pattern.receiving}") val receiving: String,
    @Value("\${websocket.url_pattern.receiving_personal}") val receivingPersonal: String
)