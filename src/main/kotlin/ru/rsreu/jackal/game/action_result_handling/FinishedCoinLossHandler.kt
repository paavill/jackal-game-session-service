package ru.rsreu.jackal.game.action_result_handling

import ru.rsreu.jackal.game.action_result_handling.util.BooleanWrapper
import ru.rsreu.jackal.game.action_result_handling.util.IntWrapper

class FinishedCoinLossHandler(private val flag: BooleanWrapper, private val winningCoinsSum: IntWrapper) :
    ActionResultHandler {
    override fun handle() {
        winningCoinsSum.int--
        flag.boolean = false
    }
}