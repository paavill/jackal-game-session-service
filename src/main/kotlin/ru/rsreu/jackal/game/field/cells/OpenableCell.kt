package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.entities.Pirate

abstract class OpenableCell : Cell {
    override var isClose: Boolean = true
        protected set

    override fun applyAction(pirate: Pirate, current: Cell) {
        if (isClose) {
            isClose = false
        }
    }
}