package ru.rsreu.jackal.game.field.cells.finished.arrows

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.DirectionQuestionHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.AbleSendToWater
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.OnePirateStoringCell

class StraightCrossShapedArrowCell(position: Position) : OnePirateStoringCell(position), AbleSendToWater {
    override val cellType: CellType = CellType.STRAIGHT_CROSS_SHAPED_ARROW
    private val directions = listOf(
        Position(0, -1),
        Position(0, 1),
        Position(-1, 0),
        Position(1, 0)
    )

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResultHandlerInitializer {
        val choiceCells = directions.map { position ->
            this.position.add(position)
        }
        super.applyAction(pirate, needTakeCoins)
        return DirectionQuestionHandlerInitializer(choiceCells)
    }
}