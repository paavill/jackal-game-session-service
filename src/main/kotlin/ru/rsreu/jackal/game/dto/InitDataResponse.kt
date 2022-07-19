package ru.rsreu.jackal.game.dto

data class InitDataResponse(
    val nextPlayerUserId: Long,
    val nextPlayerUserNumber: Number,
    val cells: List<List<CellResponse>>
) {
    val type: ActionResponseType = ActionResponseType.INIT_INFORMATION
}