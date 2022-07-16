package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.ActionResult
import ru.rsreu.jackal.game.ActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

class Water(position: Position) : CellWithSixPirates(position) {
    override val cellType: CellType = CellType.WATER
    override var isClose: Boolean = false
    var sheep: Sheep? = null

    override fun applyAction(pirate: Pirate) : ActionResult {
        val current = pirate.cell
        if (current is Water && current.sheep != null) {
            this.sheep = current.sheep
            current.sheep = null
        } else if (current is Water && this.sheep != null) {
            super.applyAction(pirate)
        }
        return ActionResult(ActionResultType.FINISHED, null)
    }

}