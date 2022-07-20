package ru.rsreu.jackal.game.field.cells.finished.arrows

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.OnePirateStoringCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType

// TODO: 20.07.2022 Можно добавить абстрактный класс с реализованным applyAction и абстрактным directions 
class DiagonalCrossShapedArrowCell(position: Position) : OnePirateStoringCell(position) {
    override val cellType: CellType = CellType.DIAGONAL_CROSS_SHAPED_ARROW
    private val directions = listOf(
        Position(-1, -1),
        Position(1, -1),
        Position(-1, 1),
        Position(1, 1)
    )

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResult {
        val choiceCells = directions.map { position ->
            this.position.add(position)
        }
        super.applyAction(pirate, needTakeCoins)
        return CellActionResult(CellActionResultType.DIRECTION_QUESTION, choiceCells)
    }
}