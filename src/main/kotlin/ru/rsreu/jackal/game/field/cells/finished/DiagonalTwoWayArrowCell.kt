package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.RotatedCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType

class DiagonalTwoWayArrowCell(position: Position, rotation: Int) : RotatedCell(position, rotation) {
    override val cellType: CellType = CellType.DIAGONAL_TWO_WAY_ARROW

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResult {
        val result = when (rotation) {
            0 -> listOf(this.position.sub(Position(1, 1)), this.position.add(Position(1, 1)))
            1 -> listOf(this.position.sub(Position(-1, 1)), this.position.add(Position(-1, 1)))
            else -> {
                listOf(Position(0, 0))
            }
        }
        super.applyAction(pirate, needTakeCoins)
        return CellActionResult(CellActionResultType.DIRECTION_QUESTION, result)
    }
}