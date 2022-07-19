package ru.rsreu.jackal.game.dto

class ActionResponseFinished(players: List<PlayerResponse>, changedCells: List<CellResponse>) :
    ActionResponse(players, changedCells) {
    override val type: ActionResponseType = ActionResponseType.GAME_ACTION_COMPLETED
}