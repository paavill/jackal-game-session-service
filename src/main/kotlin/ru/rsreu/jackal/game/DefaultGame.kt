package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.field.Field
import ru.rsreu.jackal.game.field.cells.Sheep

class DefaultGame(private val players: Map<String, Player>, val field: Field, val ships: Map<Player, Sheep>) : Game {
    override fun applyAction(uid: String, action: Action){
        val player = players[uid]!!
        field.cells[action.y][action.x]
    }
}