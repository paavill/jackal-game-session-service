package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.ActionResult
import ru.rsreu.jackal.game.ActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

class Water(position: Position) : CellWithThreePirates(position) {
    override val cellType: CellType = CellType.WATER
    override var isClose: Boolean = false
    var ship: Ship? = null

    override fun applyAction(pirate: Pirate) : ActionResult {
        val current = pirate.cell
        if (current is Water && current.ship != null) {
            this.ship = current.ship
            current.ship = null
        } else if (this.ship != null) {
            this.ship!!.applyAction(pirate)
        } else if(current!!.cellType != CellType.EMPTY){
            // TODO: 17.07.2022 Надо определить с каких ячеек пират не может ходить на воду
        }
        return super.applyAction(pirate)
    }

}