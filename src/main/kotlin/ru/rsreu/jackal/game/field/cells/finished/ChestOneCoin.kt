package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.ThreePiratesStoringCell

class ChestOneCoin(position: Position) : ThreePiratesStoringCell(position) {
    override val cellType: CellType = CellType.CHEST_1
    override var coinsNumber: Int = 1
}