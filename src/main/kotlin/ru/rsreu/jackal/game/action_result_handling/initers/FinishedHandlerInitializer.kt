package ru.rsreu.jackal.game.action_result_handling.initers

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.FinishedHandler
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class FinishedHandlerInitializer : CellActionResultHandlerInitializer {

    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return FinishedHandler(initData.flag)
    }
}