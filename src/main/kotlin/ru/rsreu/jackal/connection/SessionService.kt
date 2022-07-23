package ru.rsreu.jackal.connection

import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.stereotype.Service
import ru.rsreu.jackal.websocket.security.JwtProvider
import java.util.*

@Service
class SessionService(val jwtProvider: JwtProvider) {
    private val sessions: HashMap<String, Session> = HashMap()

    fun createNewSession(request: SessionCreationRequest): String {
        val uuid = UUID.randomUUID()
        val users = request.usersIds.associateWith { id -> User(id) }
        sessions[uuid.toString()] = Session(uuid.toString(), request.lobbyId, request.gameMode, users)
        return uuid.toString()
    }

    fun getUserSessionOrThrow(userId: Long): Session {
        val session = sessions.values.find { session -> session.isUserPresence(userId) }
        if (session != null) {
            return session
        }
        throw Exception("Нет ни пользователя ни сессии сотвественно")
    }

    fun getReconnectInfoByUserId(userId: Long): ReconnectionInformation {
        val session = getUserSessionOrThrow(userId)
        val user = session.getUserByIdOrThrow(userId)
        val jwt = jwtProvider.getJwt(user, session)
        return ReconnectionInformation(user.id, session.id, jwt)
    }

    fun getSessionById(id: String): Session = sessions[id]!!

    fun getSessionsNumber(): Int = sessions.size

    fun validateOrThrow(principal: PreAuthenticatedAuthenticationToken) {
        if (sessions[principal.credentials.toString()] != null) {
            if (!sessions[principal.credentials.toString()]!!.isUserPresence(principal.principal.toString().toLong())) {
                // TODO: 16.07.2022 Исключение: нет пользователя в сесии
                println("нет пользователя в сесии")
            }
        } else {
            // TODO: 16.07.2022 Исключение: нет сесии
            println("нет сесии")
        }
    }

    fun removeSession(sessionId: String) {
        sessions.remove(sessionId)
    }
}