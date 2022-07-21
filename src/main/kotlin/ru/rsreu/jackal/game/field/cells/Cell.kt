package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate

interface Cell {
    val isClose: Boolean
    val cellType: CellType
    val pirates: MutableList<Pirate>
    val coinsNumber: Int
    val position: Position
    fun applyAction(pirate: Pirate, needTakeCoins: Boolean) : CellActionResultHandlerInitializer
}