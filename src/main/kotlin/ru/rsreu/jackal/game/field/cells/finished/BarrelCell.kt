package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.FinishedWithFightAndActionSkipHandler
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.FinishedWithFightActionSkipInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.FinishedWithFightHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.FinishedWithPirateActionSkipInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.ThreePiratesStoringCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType

class BarrelCell(position: Position) : ThreePiratesStoringCell(position) {
    override val cellType: CellType = CellType.BARREL

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResultHandlerInitializer {
        val result = super.applyAction(pirate, needTakeCoins)
        if (result is FinishedWithFightHandlerInitializer) {
            return FinishedWithFightActionSkipInitializer()
        }
        return FinishedWithPirateActionSkipInitializer()
    }
}