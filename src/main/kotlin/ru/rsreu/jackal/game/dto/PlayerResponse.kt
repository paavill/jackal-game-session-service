package ru.rsreu.jackal.game.dto

data class PlayerResponse(
    val id: Long,
    val number: Int,
    val pirateTeam: PirateTeamResponse,
    val ships: List<CellResponse>
)