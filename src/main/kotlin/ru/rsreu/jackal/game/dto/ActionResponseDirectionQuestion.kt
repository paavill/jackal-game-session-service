package ru.rsreu.jackal.game.dto

import ru.rsreu.jackal.game.Position

class ActionResponseDirectionQuestion(
    nextPlayerUserId: Long,
    nextPlayerUserNumber: Number,
    players: List<PlayerResponse>,
    changedCells: List<CellResponse>,
    val directions: List<Position>
) :
    ActionResponse(nextPlayerUserId, nextPlayerUserNumber, players, changedCells) {
    override val type: ActionResponseType = ActionResponseType.DIRECTION_QUESTION
}