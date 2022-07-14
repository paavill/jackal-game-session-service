package ru.rsreu.jackal.connection

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SessionService(val jwtProvider: JwtProvider) {
    private val sessions: HashMap<String, Session> = HashMap()

    fun createNewSession(request: SessionCreationRequest): String{
        val uuid = UUID.randomUUID()
        val users = request.usersIds.associateWith { id -> User(id) }
        sessions[uuid.toString()] = Session(uuid.toString(), request.gameMode, users)
        val jwts = users.map { (id, user) -> jwtProvider.getJwt(user, sessions[uuid.toString()]!!) }
        return uuid.toString() + " " + jwts.toString()
    }

    fun getSessionById(id: String): Session = sessions[id]!!

    fun getSessionsNumber(): Int = sessions.size

    fun valideOrThrow(token: String) {
        //TODO переместится в сессию (проверка)
        if (sessions.keys.indexOf(token) == -1) {
            println("error")
        }
    }

}