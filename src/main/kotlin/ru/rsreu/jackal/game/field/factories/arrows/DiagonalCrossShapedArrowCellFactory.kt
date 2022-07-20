package ru.rsreu.jackal.game.field.factories.arrows

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.finished.arrows.DiagonalCrossShapedArrowCell
import ru.rsreu.jackal.game.field.factories.CellFactory

class DiagonalCrossShapedArrowCellFactory : CellFactory {

    override fun createCell(position: Position): Cell {
        return DiagonalCrossShapedArrowCell(position)
    }

}