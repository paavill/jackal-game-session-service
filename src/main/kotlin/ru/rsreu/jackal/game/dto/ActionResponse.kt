package ru.rsreu.jackal.game.dto

data class ActionResponse(val players: List<PlayerResponse>, val changedCells: List<CellResponse>)