package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.entities.Pirate

interface PirateMovableCell : Cell {
    fun setPirate(pirate: Pirate)
    fun removePirate(pirate: Pirate)
}