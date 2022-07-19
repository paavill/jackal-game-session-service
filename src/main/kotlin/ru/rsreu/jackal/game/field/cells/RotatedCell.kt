package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.Position

abstract class RotatedCell(position: Position, val rotation: Int) : OnePirateStoringCell(position)