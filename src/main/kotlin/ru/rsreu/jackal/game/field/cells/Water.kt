package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.Pirate

class Water : CellWithThreePirates() {
    override val cellType: CellType = CellType.WATER
    override var isClose: Boolean = false
    var sheep: Sheep? = null

    override fun applyAction(pirate: Pirate, current: Cell) {
        if (current is Water && current.sheep != null) {
            this.sheep = current.sheep
            current.sheep = null
        }
        super.applyAction(pirate, current)
    }

}