package ru.rsreu.jackal.game.field.factories

import ru.rsreu.jackal.game.field.cells.Cell

interface CellFactory {
    fun createCell() : Cell
}