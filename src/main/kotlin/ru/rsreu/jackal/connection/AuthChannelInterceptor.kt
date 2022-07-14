package ru.rsreu.jackal.connection

import org.springframework.messaging.Message
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaderAccessor
import org.springframework.messaging.support.ChannelInterceptor
import org.springframework.messaging.support.MessageHeaderAccessor
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component


@Component
class AuthChannelInterceptor(val jwtProvider: JwtProvider) : ChannelInterceptor {
    override fun preSend(message: Message<*>, channel: MessageChannel): Message<*>? {
        val accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor::class.java)
        val auth = jwtProvider.runCatching {
            getParsedJwt(accessor!!.getFirstNativeHeader("jwt_token")!!)
        }.getOrNull()
        if (accessor!!.user == null) {
            accessor.user = auth
        }
        return message
    }
}