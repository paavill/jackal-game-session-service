package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.RotatedCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType

class StraightOneWayArrowCell(position: Position, rotation: Int) : RotatedCell(position, rotation) {
    override val cellType: CellType = CellType.STRAIGHT_ONE_WAY_ARROW

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResult {
        val result = when (rotation) {
            0 -> this.position.sub(Position(0, 1))
            1 -> this.position.add(Position(1, 0))
            2 -> this.position.add(Position(0, 1))
            3 -> this.position.sub(Position(1, 0))
            else -> Position(0, 0)
        }
        super.applyAction(pirate, needTakeCoins)
        return CellActionResult(CellActionResultType.IN_PROCESS, listOf(result))
    }

}