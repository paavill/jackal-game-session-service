package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.entities.Pirate

class EmptyCell : CellWithThreePirates() {
    override val cellType: CellType = CellType.EMPTY
    override fun applyAction(pirate: Pirate, target: Cell) {
        super.applyAction(pirate, target)
    }
}