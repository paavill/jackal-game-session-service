package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.entities.Pirate

abstract class CellWithThreePirates : OpenableCell() {
    override val pirates: MutableList<Pirate> = mutableListOf()

    override fun applyAction(pirate: Pirate, current: Cell) {
        // TODO: 14.07.2022 исключение если идет на ту же ячейку
        val currentWithThreePirates = current as CellWithThreePirates
        currentWithThreePirates.pirates.remove(pirate)
        pirates.add(pirate)
        super.applyAction(pirate, current)
    }

    protected fun setAll(list: List<Pirate>) {
        pirates.addAll(list)
    }
}