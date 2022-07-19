package ru.rsreu.jackal.game.field.factories

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.finished.DiagonalOneWayArrowCell
import kotlin.random.Random

class DiagonalOneWayArrowCellFactory : CellFactory {

    override fun createCell(position: Position): Cell {
        return DiagonalOneWayArrowCell(position, Random.nextInt(CellType.DIAGONAL_ONE_WAY_ARROW.rotationNumber))
    }

}