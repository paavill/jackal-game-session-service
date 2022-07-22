package ru.rsreu.jackal.connection

import ru.rsreu.jackal.game.GameMode
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class SessionCreationRequest(
    @field:NotBlank
    val lobbyId: String,
    val gameMode: GameMode,
    @field:Size(min = 2, max = 4)
    val usersIds: List<Long>,
)