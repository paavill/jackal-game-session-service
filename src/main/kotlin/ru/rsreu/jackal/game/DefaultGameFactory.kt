package ru.rsreu.jackal.game

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.rsreu.jackal.connection.User
import ru.rsreu.jackal.game.field.FieldGenerationService

class DefaultGameFactory() : GameFactory {
    override fun createGame(users: Map<String, User>): Game {
        var pirateCounter = -3
        val players = users.map { (uid, user) ->
            pirateCounter+=3
            uid to Player(uid, PirateTeam(Pirate(pirateCounter), Pirate(pirateCounter + 1), Pirate(pirateCounter + 2)))
        }.toMap()
        val field = FieldGenerationService.generate()
        val ships = field.setShips(players.values.toList())
        return DefaultGame( players, field , ships)
    }
}