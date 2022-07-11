package ru.rsreu.jackal

import ru.rsreu.jackal.game.GameMode

class SessionCreationRequest(
 val sessionId: String,
 val gameMode: GameMode,
 val usersIds: List<String>) {
}