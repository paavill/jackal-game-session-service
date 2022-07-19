package ru.rsreu.jackal.game.entities

import ru.rsreu.jackal.game.field.cells.Cell

class Pirate(val number: Int, val playerId: Long) {
    var cell: Cell? = null
        private set

    fun move(cell: Cell): Cell? {
        val old = this.cell
        this.cell = cell
        return old
    }
}