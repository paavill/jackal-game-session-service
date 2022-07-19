package ru.rsreu.jackal.game.dto

import ru.rsreu.jackal.game.Position

class ActionResponseDirectionQuestion(
    players: List<PlayerResponse>,
    changedCells: List<CellResponse>,
    val directions: List<Position>
) :
    ActionResponse(players, changedCells) {
    override val type: ActionResponseType = ActionResponseType.DIRECTION_QUESTION
}