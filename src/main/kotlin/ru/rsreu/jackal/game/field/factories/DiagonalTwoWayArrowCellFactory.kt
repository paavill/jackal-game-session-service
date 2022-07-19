package ru.rsreu.jackal.game.field.factories

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.finished.DiagonalTwoWayArrowCell
import ru.rsreu.jackal.game.field.cells.finished.StraightTwoWayArrowCell
import kotlin.random.Random

class DiagonalTwoWayArrowCellFactory : CellFactory {
    override fun createCell(position: Position): Cell {
        return DiagonalTwoWayArrowCell(position, Random.nextInt(CellType.DIAGONAL_TWO_WAY_ARROW.rotationNumber))
    }
}