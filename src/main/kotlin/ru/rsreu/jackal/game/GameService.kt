package ru.rsreu.jackal.game

import org.springframework.stereotype.Service
import ru.rsreu.jackal.connection.Session
import ru.rsreu.jackal.game.field.FieldGenerationService

@Service
class GameService(val cellGenerationService: FieldGenerationService) {

    private val games: HashMap<Session, Game> = HashMap()

    fun getGameBySession(session: Session): Game {
        return games[session]!!
    }

    fun createNew(session: Session): Game {
        val players = session.users.map { (uid, user) -> uid to Player(uid) }.toMap()
        games[session] = Game( players, cellGenerationService.generate(players))
        return games[session]!!
    }

}