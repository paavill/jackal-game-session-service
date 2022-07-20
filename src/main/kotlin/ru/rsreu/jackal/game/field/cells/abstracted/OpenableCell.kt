package ru.rsreu.jackal.game.field.cells.abstracted

import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.Cell

abstract class OpenableCell(override val position: Position) : Cell {
    override var isClose: Boolean = true
        protected set

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResult {
        if (isClose) {
            isClose = false
        }
        return CellActionResult(CellActionResultType.FINISHED, null)
    }
}