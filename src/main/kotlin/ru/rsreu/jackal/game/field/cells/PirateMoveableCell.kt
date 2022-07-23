package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType
import ru.rsreu.jackal.game.entities.Pirate

interface PirateMoveableCell {
    fun setPirate(pirate: Pirate) : CellActionResultHandlerInitializer
    fun removePirate(pirate: Pirate) : CellActionResultHandlerInitializer
}