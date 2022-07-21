package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.action.GameAction
import ru.rsreu.jackal.game.action.GameActionResult
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.DefaultGameField
import ru.rsreu.jackal.game.field.cells.finished.ShipCell

interface Game {
    val field: DefaultGameField
    val nextPlayer: Player
    fun getPlayersAndShips(): Map<Player, List<ShipCell>>
    fun applyAction(gameAction: GameAction): GameActionResult

    fun getPiratesSkippingAction(): List<Pirate>

}