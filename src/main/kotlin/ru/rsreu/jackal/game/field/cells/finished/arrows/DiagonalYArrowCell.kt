package ru.rsreu.jackal.game.field.cells.finished.arrows

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.DirectionQuestionHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.AbleSendToWater
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.RotatedCell

class DiagonalYArrowCell(position: Position, rotation: Int) : RotatedCell(position, rotation), AbleSendToWater {
    override val cellType: CellType = CellType.DIAGONAL_Y_ARROW
    private val directions = mapOf(
        Pair(0, listOf(Position(1, -1), Position(-1, 0), Position(0, 1))),
        Pair(1, listOf(Position(-1, -1), Position(0, 1), Position(1, 0))),
        Pair(2, listOf(Position(-1, 1), Position(1, 0), Position(0, -1))),
        Pair(3, listOf(Position(1, 1), Position(0, -1), Position(-1, 0))),
    )

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResultHandlerInitializer {
        val directions = directions[rotation]!!
        val result = directions.map { position -> this.position.add(position) }
        super.applyAction(pirate, needTakeCoins)
        return DirectionQuestionHandlerInitializer(result)
    }
}