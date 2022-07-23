package ru.rsreu.jackal.game.field.factories.arrows

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.finished.arrows.StraightCrossShapedArrowCell
import ru.rsreu.jackal.game.field.factories.CellFactory

class StraightCrossShapedArrowCellFactory : CellFactory {

    override fun createCell(position: Position): Cell {
        return StraightCrossShapedArrowCell(position)
    }

}