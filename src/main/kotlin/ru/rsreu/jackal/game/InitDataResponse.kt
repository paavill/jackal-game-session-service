package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.field.cells.Cell

data class InitDataResponse(val nextPlayerUserId: String, val cells: List<List<CellResponse>>)