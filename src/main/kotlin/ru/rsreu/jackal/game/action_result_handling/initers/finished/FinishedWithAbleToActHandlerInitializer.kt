package ru.rsreu.jackal.game.action_result_handling.initers.finished

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.finished.FinishedWithAbleToActHandler
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class FinishedWithAbleToActHandlerInitializer : CellActionResultHandlerInitializer {
    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return FinishedWithAbleToActHandler()
    }
}