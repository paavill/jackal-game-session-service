package ru.rsreu.jackal.connection

import ru.rsreu.jackal.game.GameMode
import javax.validation.constraints.Size

data class SessionCreationRequest(
    val lobbyId: String,
    val gameMode: GameMode,
    @Size(min = 2, max = 4) val usersIds: List<Long>
)