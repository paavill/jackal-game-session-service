package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

abstract class OpenableCell(override val position: Position) : Cell {
    override var isClose: Boolean = true
        protected set

    override fun applyAction(pirate: Pirate) : CellActionResult {
        if (isClose) {
            isClose = false
        }
        return CellActionResult(CellActionResultType.FINISHED, null)
    }
}