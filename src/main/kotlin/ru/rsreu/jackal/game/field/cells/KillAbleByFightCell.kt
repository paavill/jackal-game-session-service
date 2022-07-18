package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.ActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

abstract class KillAbleByFightCell(position: Position) : CellWithThreePirates(position) {
    override fun setPirate(pirate: Pirate): ActionResultType {
        val result = super.setPirate(pirate)
        if(result == ActionResultType.FINISHED_WITH_FIGHT) {
            super.removePirate(pirate)
            return ActionResultType.FINISHED_WITH_KILL
        }
        return result
    }
}