package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.OnePirateStoringCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType

class BallCell(position: Position) : OnePirateStoringCell(position) {
    override val cellType: CellType = CellType.BALL

    override fun setPirate(pirate: Pirate): CellActionResultType {
        super.setPirate(pirate)
        return CellActionResultType.IN_PROCESS_WITH_TELEPORT_ON_SHIP
    }

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResult {
        val result = super.applyAction(pirate, needTakeCoins)
        return CellActionResult(result.type, null)
    }
}