package ru.rsreu.jackal.game.field.factories

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.finished.StraightOneWayArrowCell
import kotlin.random.Random

class StraightOneWayArrowCellFactory : CellFactory {

    override fun createCell(position: Position): Cell {
        return StraightOneWayArrowCell(position, Random.nextInt(CellType.STRAIGHT_ONE_WAY_ARROW.rotationNumber))
    }

}