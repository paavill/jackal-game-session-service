package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.Position
import kotlin.properties.Delegates
import kotlin.random.Random

abstract class RotatedCell(position: Position) : OnePirateStoringCell(position) {
    var rotation by Delegates.notNull<Int>()
        private set
    init {
        rotation = Random.nextInt(this.cellType.rotationNumber)
    }
}