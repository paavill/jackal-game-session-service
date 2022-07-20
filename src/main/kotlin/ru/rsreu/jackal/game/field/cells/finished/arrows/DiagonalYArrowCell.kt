package ru.rsreu.jackal.game.field.cells.finished.arrows

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.RotatedCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType

class DiagonalYArrowCell(position: Position, rotation: Int) : RotatedCell(position, rotation) {
    override val cellType: CellType = CellType.DIAGONAL_Y_ARROW
    private val directions = mapOf(
        Pair(0, listOf(Position(1, -1), Position(-1, 0), Position(0, 1))),
        Pair(1, listOf(Position(-1, -1), Position(0, 1), Position(1, 0))),
        Pair(2, listOf(Position(-1, 1), Position(1, 0), Position(0, -1))),
        Pair(3, listOf(Position(1, 1), Position(0, -1), Position(-1, 0))),
    )

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResult {
        val directions = directions[rotation]!!
        val result =  directions.map { position ->  this.position.add(position) }
        super.applyAction(pirate, needTakeCoins)
        return CellActionResult(CellActionResultType.DIRECTION_QUESTION, result)
    }
}