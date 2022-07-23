package ru.rsreu.jackal.game.action_result_handling.finished

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.entities.Pirate

class FinishedWithPirateSaveHandler(
    private val skipActionPirates: MutableMap<Pirate, Int>,
    private val savedPirate: Pirate
) : ActionResultHandler {
    override fun handle() {
        skipActionPirates.remove(savedPirate)
    }
}