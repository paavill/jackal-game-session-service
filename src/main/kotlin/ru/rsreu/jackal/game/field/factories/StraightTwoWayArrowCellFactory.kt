package ru.rsreu.jackal.game.field.factories

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.finished.StraightTwoWayArrowCell
import kotlin.random.Random

class StraightTwoWayArrowCellFactory : CellFactory {
    override fun createCell(position: Position): Cell {
        return StraightTwoWayArrowCell(position, Random.nextInt(CellType.STRAIGHT_TWO_WAY_ARROW.rotationNumber))
    }
}