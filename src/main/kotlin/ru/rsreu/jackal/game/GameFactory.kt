package ru.rsreu.jackal.game

import ru.rsreu.jackal.connection.User
import ru.rsreu.jackal.game.field.cells.Cell

interface GameFactory {
    fun createGame(players: Map<String, User>) : Game
}