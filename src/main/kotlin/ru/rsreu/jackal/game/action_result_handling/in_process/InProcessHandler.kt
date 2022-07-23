package ru.rsreu.jackal.game.action_result_handling.in_process

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.util.PositionWrapper

class InProcessHandler(
    private val position: Position,
    private val newPosition: PositionWrapper
) :
    ActionResultHandler, InProcess {
    override fun handle() {
        newPosition.position = position
    }
}