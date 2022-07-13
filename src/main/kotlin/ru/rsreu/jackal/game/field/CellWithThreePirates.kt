package ru.rsreu.jackal.game.field

import ru.rsreu.jackal.game.Pirate
import ru.rsreu.jackal.game.field.cells.Cell

abstract class CellWithThreePirates : Cell {
    val pirates: MutableMap<String, Pirate> = mutableMapOf()
    override var isClose: Boolean = true

    override fun applyAction(pirate: Pirate) {

    }
}