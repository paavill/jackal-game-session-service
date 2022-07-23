package ru.rsreu.jackal.game.field.cells.finished.arrows

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.DirectionQuestionHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.RotatedCell

class StraightTwoWayArrowCell(position: Position, rotation: Int) : RotatedCell(position, rotation) {
    override val cellType: CellType = CellType.STRAIGHT_TWO_WAY_ARROW

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResultHandlerInitializer {
        val result = when (rotation) {
            0 -> listOf(this.position.sub(Position(0, 1)), this.position.add(Position(0, 1)))
            1 -> listOf(this.position.sub(Position(1, 0)), this.position.add(Position(1, 0)))
            else -> {
                listOf(Position(0, 0))
            }
        }
        super.applyAction(pirate, needTakeCoins)
        return DirectionQuestionHandlerInitializer(result)
    }
}