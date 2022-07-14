package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.DefaultGameField
import ru.rsreu.jackal.game.field.cells.Sheep

class DefaultGame(private val players: Map<String, Player>,
                  override val field: DefaultGameField,
                  val ships: Map<Player, Sheep>) : Game {

    override var nextPlayer: Player = players.values.first()
        private set

    override fun applyAction(action: Action){
        val player = players[action.playerId]!!
        val pirate = player.pirateTeam.getPirateByNumber(action.pirateNumber)
        val cell = field.cells[action.y][action.x]
        cell.applyAction(pirate, cell)
    }
}