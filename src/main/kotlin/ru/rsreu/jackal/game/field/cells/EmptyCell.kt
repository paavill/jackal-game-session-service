package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.ActionResult
import ru.rsreu.jackal.game.ActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

class EmptyCell(position: Position) : CellWithThreePirates(position) {
    override val cellType: CellType = CellType.EMPTY
    override fun applyAction(pirate: Pirate) : ActionResult {
        return super.applyAction(pirate)
    }
}