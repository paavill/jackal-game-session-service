package ru.rsreu.jackal.websocket.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.stereotype.Component
import ru.rsreu.jackal.connection.Session
import ru.rsreu.jackal.connection.User
import javax.crypto.SecretKey

@Component
class JwtProvider {
    val key: SecretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512)
    fun getJwt(user: User, session: Session) : String {
        return Jwts.builder()
            .setSubject("user")
            .claim("userId", user.uid)
            .claim("sessionId", session.id)
            .signWith(key)
            .compact()
    }

    fun getAuthenticationFromToken(token: String) : Authentication {
        val map = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
        val id = map.body["userId"]
        val sessionId = map.body["sessionId"]
        val auth = PreAuthenticatedAuthenticationToken(id, sessionId)
        auth.isAuthenticated = true
        return auth
    }
}