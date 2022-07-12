package ru.rsreu.jackal.connection

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class SessionService {
    private val sessions: HashMap<String, Session> = HashMap()

    fun createNewSession(request: SessionCreationRequest): String{
        val uuid = UUID.randomUUID()
        val users = request.usersIds.associateWith { id -> User(id) }
        sessions[uuid.toString()] = Session(uuid.toString(), users)
        return uuid.toString()
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