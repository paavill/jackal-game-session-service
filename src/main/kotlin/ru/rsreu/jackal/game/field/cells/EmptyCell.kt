package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.Pirate
import ru.rsreu.jackal.game.field.CellWithThreePirates

class EmptyCell : CellWithThreePirates() {
    override val pirates: MutableList<Pirate> = mutableListOf()
    override fun applyAction(pirate: Pirate) {
        super.applyAction(pirate)
    }
}