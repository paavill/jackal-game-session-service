package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.ThreePiratesStoringCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult

class BarrelCell(position: Position) : ThreePiratesStoringCell(position) {
    override val cellType: CellType = CellType.BARREL

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResult {
        return super.applyAction(pirate, needTakeCoins)
    }
}