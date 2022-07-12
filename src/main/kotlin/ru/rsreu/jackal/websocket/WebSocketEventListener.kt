package ru.rsreu.jackal.websocket

import org.springframework.context.event.EventListener
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionDisconnectEvent
import org.springframework.web.socket.messaging.SessionSubscribeEvent

@Component
class WebSocketEventListener {

    @EventListener
    fun subscribeEventListener(event : SessionSubscribeEvent) {
        println(event.message)
    }

    @EventListener
    fun disconnectEventListener(event: SessionDisconnectEvent){
        println(event.message)
    }
}