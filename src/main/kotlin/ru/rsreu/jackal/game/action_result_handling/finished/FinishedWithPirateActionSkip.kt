package ru.rsreu.jackal.game.action_result_handling.finished

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.util.BooleanWrapper
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player

class FinishedWithPirateActionSkip(
    private val skipNumber: Int,
    private val flag: BooleanWrapper,
    private val nextPlayer: Player,
    private val pirate: Pirate,
    private val piratesSkippingAction: MutableMap<Pirate, Int>
) : ActionResultHandler {
    override fun handle() {
        piratesSkippingAction[pirate] = skipNumber
        flag.boolean = false
    }
}