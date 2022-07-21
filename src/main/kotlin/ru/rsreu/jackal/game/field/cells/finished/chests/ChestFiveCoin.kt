package ru.rsreu.jackal.game.field.cells.finished.chests

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.ThreePiratesStoringCell

class ChestFiveCoin(position: Position) : ThreePiratesStoringCell(position) {
    override val cellType: CellType = CellType.CHEST_5
    override var coinsNumber: Int = 5
}