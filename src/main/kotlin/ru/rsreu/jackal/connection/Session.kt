package ru.rsreu.jackal.connection

import ru.rsreu.jackal.game.GameMode

class Session(val id: String, val gameMode: GameMode, val users: Map<String, User>) {
    fun isUserPresence(userId: String) : Boolean {
        return users[userId] != null
    }
}