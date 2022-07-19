package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.RotatedCell

class StraightTwoWayArrowCell(position: Position) : RotatedCell(position) {
    override val cellType: CellType = CellType.STRAIGHT_TWO_WAY_ARROW

    override fun applyAction(pirate: Pirate): CellActionResult {
        when (rotation) {
            0 -> listOf(this.position.sub(Position(0, 1)), this.position.add(Position(0, 1)))
            1 -> listOf(this.position.sub(Position(1, 0)), this.position.add(Position(1, 0)))
        }
        return super.applyAction(pirate)
    }
}