package ru.rsreu.jackal.connection

import ru.rsreu.jackal.game.GameMode

class Session(val id: String, val lobbyId: String, val gameMode: GameMode, val users: Map<Long, User>) {
    fun isUserPresence(userId: Long): Boolean {
        return users[userId] != null
    }
}