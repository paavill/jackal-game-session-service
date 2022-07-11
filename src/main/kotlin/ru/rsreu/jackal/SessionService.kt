package ru.rsreu.jackal

import org.springframework.stereotype.Service

@Service
class SessionService {

    private val sessions: HashMap<String, Session> = HashMap()

    fun createNewSession(id: String){
        sessions[id] = Session(id)
    }

    fun getSessionById(id: String): Session = sessions[id]!!

    fun getSessionsNumber(): Int = sessions.size

}