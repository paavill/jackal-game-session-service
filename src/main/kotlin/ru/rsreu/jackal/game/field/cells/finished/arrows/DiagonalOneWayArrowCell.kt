package ru.rsreu.jackal.game.field.cells.finished.arrows

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.RotatedCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType

class DiagonalOneWayArrowCell(position: Position, rotation: Int) : RotatedCell(position, rotation) {
    override val cellType: CellType = CellType.DIAGONAL_ONE_WAY_ARROW

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResult {
        val result = when (rotation) {
            0 -> this.position.sub(Position(1, 1))
            1 -> this.position.add(Position(1, 1))
            2 -> this.position.add(Position(1, 1))
            3 -> this.position.sub(Position(1, 1))
            else -> Position(0, 0)
        }
        super.applyAction(pirate, needTakeCoins)
        return CellActionResult(CellActionResultType.IN_PROCESS, listOf(result))
    }

}