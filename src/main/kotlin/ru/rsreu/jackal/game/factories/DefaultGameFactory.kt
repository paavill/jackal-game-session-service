package ru.rsreu.jackal.game.factories

import ru.rsreu.jackal.connection.User
import ru.rsreu.jackal.game.DefaultGame
import ru.rsreu.jackal.game.Game
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.PirateTeam
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.FieldGenerationService

class DefaultGameFactory : GameFactory {
    override fun createGame(users: Map<String, User>): Game {
        var pirateCounter = -3
        var playerCounter = -1
        val players = users.map { (uid, _) ->
            pirateCounter+=3
            playerCounter+=1
            uid to Player(uid, playerCounter,
                PirateTeam(Pirate(pirateCounter, uid),
                            Pirate(pirateCounter + 1, uid),
                            Pirate(pirateCounter + 2, uid)))
        }.toMap()
        val field = FieldGenerationService.generate()
        val ships = field.setShips(players.values.toList())
        return DefaultGame( players, field , ships)
    }
}