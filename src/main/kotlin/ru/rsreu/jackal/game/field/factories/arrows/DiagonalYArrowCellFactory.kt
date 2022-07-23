package ru.rsreu.jackal.game.field.factories.arrows

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.finished.arrows.DiagonalYArrowCell
import ru.rsreu.jackal.game.field.factories.CellFactory
import kotlin.random.Random

class DiagonalYArrowCellFactory : CellFactory {
    override fun createCell(position: Position): Cell {
        return DiagonalYArrowCell(position, Random.nextInt(CellType.DIAGONAL_Y_ARROW.rotationNumber))
    }
}