package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.DirectionQuestionHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.AbleSendToWater
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.OnePirateStoringCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType

class HorseCell(position: Position) : OnePirateStoringCell(position), AbleSendToWater {
    override val cellType: CellType = CellType.HORSE
    private val directions = listOf(
        Position(-1, -2),
        Position(1, -2),
        Position(-1, 2),
        Position(1, 2),
        Position(-2, -1),
        Position(-2, 1),
        Position(2, -1),
        Position(2, 1),
    )

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResultHandlerInitializer {
        val result =  directions.map { position ->  this.position.add(position) }
        super.applyAction(pirate, needTakeCoins)
        return DirectionQuestionHandlerInitializer(result)
    }
}