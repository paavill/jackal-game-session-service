package ru.rsreu.jackal.game

import org.springframework.stereotype.Service
import ru.rsreu.jackal.connection.Session

@Service
class GameService {

    private val games: HashMap<Session, Game> = HashMap()

    fun getGameBySession(session: Session): Game {
        return games[session]!!
    }

    fun createNewOrReturnExistingGameBySession(session: Session): Game {
        if (games[session] == null) {
            games[session] = session.gameMode.factory.createGame(session.users)
        }
        return games[session]!!
    }

}