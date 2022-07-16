package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.ActionResult
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

interface Cell {
    val isClose: Boolean
    val cellType: CellType
    val pirates: MutableList<Pirate>
    val position: Position
    fun applyAction(pirate: Pirate) : ActionResult
}