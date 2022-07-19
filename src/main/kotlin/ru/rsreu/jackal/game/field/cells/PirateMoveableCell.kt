package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.field.cells.action.CellActionResultType
import ru.rsreu.jackal.game.entities.Pirate

interface PirateMoveableCell {
    fun setPirate(pirate: Pirate) : CellActionResultType
    fun removePirate(pirate: Pirate) : CellActionResultType
}