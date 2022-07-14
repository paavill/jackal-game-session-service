package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.field.DefaultGameField
import ru.rsreu.jackal.game.field.cells.Sheep

class DefaultGame(private val players: Map<String, Player>, val field: DefaultGameField, val ships: Map<Player, Sheep>) : Game {
    override fun applyAction(action: Action){
        val player = players[action.playerId]!!
        val pirate = player.pirateTeam.getPirateByNumber(action.pirateNumber)
        val cell = field.cells[action.y][action.x]
        cell.applyAction(pirate, cell)
    }
}