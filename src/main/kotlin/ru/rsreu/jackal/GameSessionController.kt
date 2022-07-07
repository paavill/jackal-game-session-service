package ru.rsreu.jackal

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GameSessionController(@PathVariable private val id: String = "") {

    @MessageMapping("/game-session/action/{id}")
    @SendTo("/game-session/action-result/{id}")
    fun printHello(): String = "Hello$id"

}