package ru.rsreu.jackal.game.action_result_handling

import ru.rsreu.jackal.game.action_result_handling.util.BooleanWrapper

class FinishedHandler(private val flag: BooleanWrapper) : ActionResultHandler {
    override fun handle() {
        flag.boolean = false
    }
}