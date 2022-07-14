package ru.rsreu.jackal

import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.messaging.simp.config.ChannelRegistration

import org.springframework.web.socket.config.annotation.StompEndpointRegistry

import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer
import ru.rsreu.jackal.connection.AuthChannelInterceptor


@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE + 99)
class WebSocketAuthenticationSecurityConfig(val authChannelInterceptorAdapter: AuthChannelInterceptor?) : WebSocketMessageBrokerConfigurer {
    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        // Endpoints are already registered on WebSocketConfig, no need to add more.
    }

    override fun configureClientInboundChannel(registration: ChannelRegistration) {
        registration.setInterceptors(authChannelInterceptorAdapter)
    }
}
