package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.ThreePiratesStoringCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType

class BarrelCell(position: Position) : ThreePiratesStoringCell(position) {
    override val cellType: CellType = CellType.BARREL

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResult {
        val result = super.applyAction(pirate, needTakeCoins)
        if (result.type == CellActionResultType.FINISHED_WITH_FIGHT) {
            return CellActionResult(CellActionResultType.FINISHED_WITH_PIRATE_ACTION_SKIP_AND_FIGHT, result.position)
        }
        return CellActionResult(CellActionResultType.FINISHED_WITH_PIRATE_ACTION_SKIP, result.position)
    }
}