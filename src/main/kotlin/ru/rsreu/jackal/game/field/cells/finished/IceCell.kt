package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.OnePirateStoringCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType

class IceCell(position: Position) : OnePirateStoringCell(position) {
    override val cellType: CellType = CellType.ICE

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResult {
        val result = super.applyAction(pirate, needTakeCoins)
        return CellActionResult(CellActionResultType.IN_PROCESS_REPEAT_ACTION, result.position)
    }
}