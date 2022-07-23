package ru.rsreu.jackal.game.dto

class ActionResponseFinishedWithAbleToAct(
    nextPlayerUserId: Long,
    nextPlayerUserNumber: Number,
    players: List<PlayerResponse>,
    changedCells: List<CellResponse>
) :
    ActionResponse(nextPlayerUserId, nextPlayerUserNumber, players, changedCells) {
    override val type: ActionResponseType = ActionResponseType.GAME_ACTION_COMPLETED_WITH_ABLE_TO_ACT
}
