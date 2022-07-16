package ru.rsreu.jackal.game.dto

import ru.rsreu.jackal.game.entities.Player

data class InitDataResponse(val nextPlayerUserId: String, val nextPlayerUserNumber: Number, val cells: List<List<CellResponse>>)