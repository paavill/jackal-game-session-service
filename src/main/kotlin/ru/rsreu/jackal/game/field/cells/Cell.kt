package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.entities.Pirate

interface Cell {
    val isClose: Boolean
    val cellType: CellType
    val pirates: MutableList<Pirate>
    fun applyAction(pirate: Pirate, current: Cell)
}