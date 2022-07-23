package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.*
import ru.rsreu.jackal.game.action_result_handling.initers.finished.FinishedPirateToSkipHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.finished.FinishedWithFightActionSkipInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.finished.FinishedWithFightHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.finished.FinishedWithPirateSaveHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.ThreePiratesStoringCell

class TrapCell(position: Position) : ThreePiratesStoringCell(position) {
    override val cellType: CellType = CellType.TRAP

    override fun setPirate(pirate: Pirate): CellActionResultHandlerInitializer {
        val pirateSaved = if (pirates.size == 1) {
            pirates[0]
        } else {
            null
        }
        val result = super.setPirate(pirate)
        if (pirates.size == 1) {
            return FinishedPirateToSkipHandlerInitializer(-1)
        } else if (result is FinishedWithFightHandlerInitializer) {
            return FinishedWithFightActionSkipInitializer(-1)
        }
        return FinishedWithPirateSaveHandlerInitializer(pirateSaved!!)
    }

}