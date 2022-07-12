package ru.rsreu.jackal.game.field

import ru.rsreu.jackal.game.Pirate
import ru.rsreu.jackal.game.field.cells.Cell

abstract class CellWithThreePirates : Cell {
    private val pirates: MutableList<Pirate> = mutableListOf()
    override var isClose: Boolean = true

    override fun applyAction(pirate: Pirate) {
        TODO("Not yet implemented")
    }

    override fun clone(): Any {
        return super.clone()
    }
}