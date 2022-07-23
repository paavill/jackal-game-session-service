package ru.rsreu.jackal.game.field.cells.abstracted

import ru.rsreu.jackal.game.field.cells.action.CellActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.FinishedWithFightHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.FinishedWithKillHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate

abstract class KillAbleByFightCell(position: Position) : ThreePiratesStoringCell(position) {
    override fun setPirate(pirate: Pirate): CellActionResultHandlerInitializer {
        val result = super.setPirate(pirate)
        if(result is FinishedWithFightHandlerInitializer) {
            super.removePirate(pirate)
            return FinishedWithKillHandlerInitializer()
        }
        return result
    }
}