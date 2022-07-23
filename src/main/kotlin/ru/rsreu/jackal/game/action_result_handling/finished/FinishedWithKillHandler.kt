package ru.rsreu.jackal.game.action_result_handling.finished

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.util.BooleanWrapper
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player

class FinishedWithKillHandler(
    private val flag: BooleanWrapper,
    private val pirate: Pirate,
    private val nextPlayer: Player
) : ActionResultHandler {
    override fun handle() {
        kill()
        flag.boolean = false
    }

    private fun kill() {
        nextPlayer.pirateTeam.killPirate(pirate)
    }
}