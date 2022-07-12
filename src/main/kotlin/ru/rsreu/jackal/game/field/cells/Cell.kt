package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.Pirate

interface Cell : Cloneable {
    var isClose: Boolean
    fun applyAction(pirate: Pirate)
}