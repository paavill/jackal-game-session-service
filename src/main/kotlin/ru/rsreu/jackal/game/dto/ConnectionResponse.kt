package ru.rsreu.jackal.game.dto

// TODO: 21.07.2022 Для всех респонсов добавить абстрактный класс для соблюдения контракта по полю типа
data class ConnectionResponse(
    val playerId: Long,
    val message: String
) {
    val type: ActionResponseType = ActionResponseType.CONNECTION_INFO
}