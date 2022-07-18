package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.ActionResultType
import ru.rsreu.jackal.game.entities.Pirate

interface PirateMoveAbleCell {
    fun setPirate(pirate: Pirate) : ActionResultType
    fun removePirate(pirate: Pirate) : ActionResultType
}