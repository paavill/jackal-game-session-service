package ru.rsreu.jackal

import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.Headers
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.stereotype.Controller

@Controller
class SessionController(private val sessionService: SessionService) {
    @MessageMapping("/action/{id}")
    @SendTo("/jackal-broker/action-result/{id}")
    fun printHello(@DestinationVariable("id") id: String, @Payload message: String, headers: MessageHeaders): String {
        println("Message: $message")
        headers.forEach { t, u ->  println("$t = $u")}
        return "Hello " + sessionService.getSessionById(id).id
    }
}