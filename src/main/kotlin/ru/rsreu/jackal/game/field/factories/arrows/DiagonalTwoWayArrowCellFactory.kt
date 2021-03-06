package ru.rsreu.jackal.game.field.factories.arrows

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.finished.arrows.DiagonalTwoWayArrowCell
import ru.rsreu.jackal.game.field.factories.CellFactory
import kotlin.random.Random

class DiagonalTwoWayArrowCellFactory : CellFactory {
    override fun createCell(position: Position): Cell {
        return DiagonalTwoWayArrowCell(position, Random.nextInt(CellType.DIAGONAL_TWO_WAY_ARROW.rotationNumber))
    }
}