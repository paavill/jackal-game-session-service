package ru.rsreu.jackal.game.action_result_handling.finished

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.util.BooleanWrapper

class FinishedHandler(private val flag: BooleanWrapper) : ActionResultHandler {
    override fun handle() {
        flag.boolean = false
    }
}