package ru.rsreu.jackal.game.field.factories

import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.EmptyCell

class EmptyCellFactory : CellFactory {
    override fun createCell(): Cell {
        return EmptyCell()
    }
}