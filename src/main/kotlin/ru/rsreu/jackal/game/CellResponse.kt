package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.field.cells.CellType

data class CellResponse(
    val cellType: CellType,
    val rotationId: Int,
    val pirates: List<Int>,
    val coinsNumber: Int)