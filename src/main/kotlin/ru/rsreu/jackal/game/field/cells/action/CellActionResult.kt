package ru.rsreu.jackal.game.field.cells.action

import ru.rsreu.jackal.game.Position

data class CellActionResult(val type: CellActionResultType, val position: List<Position>?)