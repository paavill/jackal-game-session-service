package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.ZeroPirateStoringCell

class CannibalCell(position: Position) : ZeroPirateStoringCell(position) {
    override val cellType: CellType = CellType.CANNIBAL
}