package ru.rsreu.jackal.game.action_result_handling

import ru.rsreu.jackal.game.Position

// TODO: 22.07.2022 Вынести размеры карты, для универсальности класса 
class DirectionQuestionHandler(
    private val directionVariants: MutableList<Position>,
    private val fromCellVariants: List<Position>
) :
    ActionResultHandler {
    override fun handle() {
        val checkedVariants = fromCellVariants.filter { position ->
            position.x >= 0 && position.y >= 0 && position.x < 13 && position.y < 13
        }
        directionVariants.addAll(checkedVariants)
    }
}