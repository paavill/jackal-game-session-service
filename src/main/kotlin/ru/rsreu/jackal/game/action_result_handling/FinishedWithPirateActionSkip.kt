package ru.rsreu.jackal.game.action_result_handling

import ru.rsreu.jackal.game.action_result_handling.util.BooleanWrapper
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player

class FinishedWithPirateActionSkip(
    private val flag: BooleanWrapper,
    private val nextPlayer: Player,
    private val pirate: Pirate,
    private val piratesSkippingAction: MutableMap<Player, Pirate>
) : ActionResultHandler {
    override fun handle() {
        piratesSkippingAction[nextPlayer] = pirate
        flag.boolean = false
    }
}