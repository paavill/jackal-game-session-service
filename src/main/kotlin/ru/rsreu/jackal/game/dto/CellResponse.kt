package ru.rsreu.jackal.game.dto

import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.Position

data class CellResponse(
    val cellType: CellType,
    val position: Position,
    val rotationId: Int,
    val pirates: List<Int>,
    val coinsNumber: Int)