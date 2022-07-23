package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.finished.FinishedWithAbleToActHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.ZeroPirateStoringCell

class CrocodileCell(position: Position) : ZeroPirateStoringCell(position) {
    override val cellType: CellType = CellType.CROCODILE

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResultHandlerInitializer {
        val result = super.applyAction(pirate, needTakeCoins)
        if (isClose) {
            return result
        }
        return FinishedWithAbleToActHandlerInitializer()
    }
}