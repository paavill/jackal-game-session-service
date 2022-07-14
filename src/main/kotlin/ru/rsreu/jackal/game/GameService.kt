package ru.rsreu.jackal.game

import org.springframework.stereotype.Service
import ru.rsreu.jackal.connection.Session
import ru.rsreu.jackal.game.field.FieldGenerationService

@Service
class GameService {

    private val games: HashMap<Session, Game> = HashMap()

    fun getGameBySession(session: Session): Game {
        return games[session]!!
    }

    fun createNew(session: Session): Game {
        games[session] = session.gameMode.factory.createGame(session.users)
        return games[session]!!
    }

}