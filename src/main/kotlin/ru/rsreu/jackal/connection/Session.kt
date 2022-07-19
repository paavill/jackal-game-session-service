package ru.rsreu.jackal.connection

import ru.rsreu.jackal.game.GameMode

class Session(val id: String, val lobbyId: String, val gameMode: GameMode, private val users: Map<Long, User>) {
    fun isUserPresence(userId: Long): Boolean {
        return users[userId] != null
    }

    fun getUserByIdOrThrow(userId: Long) : User {
        if (isUserPresence(userId)) {
            return users[userId]!!
        } else {
            throw Exception("User with id: $userId is not in session with id: $id")
        }
    }

    fun getAllUsers() : List<User> {
        return users.values.toList()
    }

    fun getUserIdToUserMap(): Map<Long, User> {
        return users
    }
}