package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.ThreePiratesStoringCell

class EmptyCell(position: Position) : ThreePiratesStoringCell(position) {
    override val cellType: CellType = CellType.EMPTY
}