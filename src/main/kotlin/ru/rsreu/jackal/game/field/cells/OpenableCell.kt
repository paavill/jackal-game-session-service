package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.ActionResult
import ru.rsreu.jackal.game.ActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

abstract class OpenableCell(override val position: Position) : Cell {
    override var isClose: Boolean = true
        protected set

    override fun applyAction(pirate: Pirate) : ActionResult {
        if (isClose) {
            isClose = false
        }
        return ActionResult(ActionResultType.FINISHED, null)
    }
}