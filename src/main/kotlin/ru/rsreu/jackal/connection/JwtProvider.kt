package ru.rsreu.jackal.connection

import io.jsonwebtoken.Header
import io.jsonwebtoken.Jwt
import io.jsonwebtoken.Jwts
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.stereotype.Component

@Component
class JwtProvider {
    fun getJwt(user: User, session: Session) : String {
        return Jwts.builder().setClaims(mapOf(
            Pair("userId", user.uid),
            Pair("sessionId", session.id)
        )).compact()
    }

    fun getParsedJwt(token: String) : Authentication {
        val map = Jwts.parser().parseClaimsJwt(token)
        val id = map.body.get("userId", String.javaClass)
        val sessionId = map.body.get("sessionId", String.javaClass)
        return PreAuthenticatedAuthenticationToken(id, sessionId)
    }
}