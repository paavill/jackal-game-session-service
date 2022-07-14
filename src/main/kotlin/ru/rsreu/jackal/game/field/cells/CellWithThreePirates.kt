package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.Pirate

abstract class CellWithThreePirates : Cell {
    private val pirates: MutableList<Pirate> = mutableListOf()
    override var isClose: Boolean = true

    override fun applyAction(pirate: Pirate, current: Cell) {
        if (isClose) {
            isClose = false
        }
        // TODO: 14.07.2022 исключение если идет на ту же ячейку
        val currentWithThreePirates = current as CellWithThreePirates
        currentWithThreePirates.pirates.remove(pirate)
        pirates.add(pirate)
    }

    protected fun setAll(list: List<Pirate>) {
        pirates.addAll(list)
    }
}