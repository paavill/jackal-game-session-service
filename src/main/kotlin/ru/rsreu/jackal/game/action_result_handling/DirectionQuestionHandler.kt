package ru.rsreu.jackal.game.action_result_handling

import ru.rsreu.jackal.game.Position

class DirectionQuestionHandler(
    private val directionVariants: MutableList<Position>,
    private val fromCellVariants: List<Position>
) :
    ActionResultHandler {
    override fun handle() {
        directionVariants.addAll(fromCellVariants)
    }
}