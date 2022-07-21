package ru.rsreu.jackal.game.dto

class ActionResponseFinished(
    nextPlayerUserId: Long,
    nextPlayerUserNumber: Number,
    players: List<PlayerResponse>,
    changedCells: List<CellResponse>
) :
    ActionResponse(nextPlayerUserId, nextPlayerUserNumber, players, changedCells) {
    override val type: ActionResponseType = ActionResponseType.GAME_ACTION_COMPLETED
}