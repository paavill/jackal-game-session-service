package ru.rsreu.jackal.game.action_result_handling.finished

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.util.BooleanWrapper
import ru.rsreu.jackal.game.action_result_handling.util.IntWrapper

class FinishedCoinLossHandler(
    private val flag: BooleanWrapper,
    private val winningCoinsSum: IntWrapper,
    private val wrappedHandler: ActionResultHandler
) :
    ActionResultHandler {
    override fun handle() {
        winningCoinsSum.int--
        flag.boolean = false
        wrappedHandler.handle()
    }
}