package ru.rsreu.jackal.game.field.cells.finished.arrows

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.OnePirateStoringCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType

class StraightCrossShapedArrowCell(position: Position) : OnePirateStoringCell(position) {
    override val cellType: CellType = CellType.STRAIGHT_CROSS_SHAPED_ARROW
    private val directions = listOf(
        Position(0, -1),
        Position(0, 1),
        Position(-1, 0),
        Position(1, 0)
    )

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResult {
        val choiceCells = directions.map { position ->
            this.position.add(position)
        }
        super.applyAction(pirate, needTakeCoins)
        return CellActionResult(CellActionResultType.DIRECTION_QUESTION, choiceCells)
    }
}