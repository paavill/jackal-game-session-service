package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.OnePirateStoringCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType

class HorseCell(position: Position) : OnePirateStoringCell(position) {
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

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResult {
        val result =  directions.map { position ->  this.position.add(position) }
        super.applyAction(pirate, needTakeCoins)
        return CellActionResult(CellActionResultType.DIRECTION_QUESTION, result)
    }
}