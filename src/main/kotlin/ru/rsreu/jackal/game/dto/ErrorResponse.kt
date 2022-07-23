package ru.rsreu.jackal.game.dto

class ErrorResponse(val message: String) {
    val type: ActionResponseType = ActionResponseType.ERROR
}