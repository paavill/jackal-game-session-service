package ru.rsreu.jackal.game.action_result_handling

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.util.PositionWrapper

class InProcessHandler(
    private val position: Position,
    private val newPosition: PositionWrapper
) :
    ActionResultHandler {
    override fun handle() {
        newPosition.position = position
    }
}