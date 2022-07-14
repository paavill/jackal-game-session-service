package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.field.cells.Cell

class Pirate(val number: Int) {
    private lateinit var cell: Cell
    fun move(cell: Cell) {
        this.cell = cell
    }
}