package ru.rsreu.jackal.websocket.security

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.SimpMessageType
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer

@Configuration
class WebSocketAuthorizationSecurityConfig : AbstractSecurityWebSocketMessageBrokerConfigurer() {
    override fun configureInbound(messages: MessageSecurityMetadataSourceRegistry?) {
        messages!!.simpTypeMatchers(SimpMessageType.DISCONNECT).permitAll()
            .anyMessage().authenticated()
    }

    override fun sameOriginDisabled(): Boolean {
        return true
    }
}