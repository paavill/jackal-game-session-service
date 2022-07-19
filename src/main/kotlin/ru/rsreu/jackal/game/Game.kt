package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.action.GameAction
import ru.rsreu.jackal.game.action.GameActionResult
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.DefaultGameField
import ru.rsreu.jackal.game.field.cells.finished.Ship

interface Game {
    val field: DefaultGameField
    val nextPlayer: Player
    fun getPlayersAndShips() : Map<Player, List<Ship>>
    fun applyAction(gameAction: GameAction) : GameActionResult

}