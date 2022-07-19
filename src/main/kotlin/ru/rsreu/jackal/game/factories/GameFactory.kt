package ru.rsreu.jackal.game.factories

import ru.rsreu.jackal.connection.User
import ru.rsreu.jackal.game.Game

interface GameFactory {
    fun createGame(users: Map<Long, User>): Game
}