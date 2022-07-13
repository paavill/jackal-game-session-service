package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.Pirate
import ru.rsreu.jackal.game.field.CellWithThreePirates

class Water : CellWithThreePirates() {

    var sheep: Sheep? = null

    override fun applyAction(pirate: Pirate) {

    }

}