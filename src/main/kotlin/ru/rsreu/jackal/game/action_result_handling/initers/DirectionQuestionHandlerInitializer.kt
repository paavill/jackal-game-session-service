package ru.rsreu.jackal.game.action_result_handling.initers

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.DirectionQuestionHandler
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class DirectionQuestionHandlerInitializer(private val fromCellVariants: List<Position>) :
    CellActionResultHandlerInitializer {

    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return DirectionQuestionHandler(initData.directionVariants, fromCellVariants)
    }
}