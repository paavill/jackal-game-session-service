package ru.rsreu.jackal.game.field.cells.abstracted

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.FinishedHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.Cell

abstract class OpenableCell(override val position: Position) : Cell {
    override var isClose: Boolean = true
        protected set

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResultHandlerInitializer {
        if (isClose) {
            isClose = false
        }
        return FinishedHandlerInitializer()
    }
}