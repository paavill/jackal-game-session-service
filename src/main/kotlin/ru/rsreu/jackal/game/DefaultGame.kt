package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.field.Field
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.Sheep

class DefaultGame(private val players: Map<String, Player>, val field: Field) : Game {
    val ships: Map<Player, Sheep> = field.setShips(players.values.toList())

    override fun applyAction(uid: String, action: Action){
        val player = players[uid]!!
        field.field[action.y][action.x]
    }
}