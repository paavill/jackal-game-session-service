package ru.rsreu.jackal.game

import org.springframework.stereotype.Service
import ru.rsreu.jackal.connection.Session
import ru.rsreu.jackal.game.field.FieldGenerationService

@Service
class GameService(val cellGenerationService: FieldGenerationService) {

    private val games: HashMap<Session, DefaultGame> = HashMap()

    fun getGameBySession(session: Session): DefaultGame {
        return games[session]!!
    }

    fun createNew(session: Session): Game {
        session.gameMode.factory.createGame(session.users)
        return games[session]!!
    }

}