package ru.rsreu.jackal.game.dto

data class PlayerResponse(val uid: String, val number: Int, val pirateTeam: PirateTeamResponse, val ships: List<CellResponse>)