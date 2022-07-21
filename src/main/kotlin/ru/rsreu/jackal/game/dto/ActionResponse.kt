package ru.rsreu.jackal.game.dto

abstract class ActionResponse(
    val nextPlayerUserId: Long,
    val nextPlayerUserNumber: Number,
    val players: List<PlayerResponse>,
    val changedCells: List<CellResponse>
) {
    abstract val type: ActionResponseType
}