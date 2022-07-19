package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.field.cells.action.CellActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

abstract class KillAbleByFightCell(position: Position) : ThreePiratesStoringCell(position) {
    override fun setPirate(pirate: Pirate): CellActionResultType {
        val result = super.setPirate(pirate)
        if(result == CellActionResultType.FINISHED_WITH_FIGHT) {
            super.removePirate(pirate)
            return CellActionResultType.FINISHED_WITH_KILL
        }
        return result
    }
}