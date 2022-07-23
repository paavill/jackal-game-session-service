package ru.rsreu.jackal.game.field.factories

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.finished.TrapCell

class TrapCellFactory : CellFactory {
    override fun createCell(position: Position): Cell {
        return TrapCell(position)
    }
}