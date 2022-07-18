package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.CellWithThreePirates

class EmptyCell(position: Position) : CellWithThreePirates(position) {
    override val cellType: CellType = CellType.EMPTY
}