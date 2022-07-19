package ru.rsreu.jackal.websocket

import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.messaging.support.ChannelInterceptor
import org.springframework.messaging.support.MessageHeaderAccessor
import org.springframework.stereotype.Component
import ru.rsreu.jackal.websocket.security.JwtProvider

@Component
class AuthChannelInterceptor(val jwtProvider: JwtProvider) : ChannelInterceptor {
    override fun preSend(message: Message<*>, channel: MessageChannel): Message<*>? {
        val accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor::class.java)
        if (accessor!!.user == null) {
            val auth = jwtProvider.runCatching {
                getAuthenticationFromToken(accessor.getFirstNativeHeader("jwt_token")!!)
            }.getOrNull()
            accessor.user = auth
        }
        return message
    }
}