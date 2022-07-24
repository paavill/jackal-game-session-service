package ru.rsreu.jackal.game.action_result_handling.initers

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.finished.FinishedCoinLossHandler
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class FinishedCoinLossHandlerInitializer(private val init: CellActionResultHandlerInitializer) : CellActionResultHandlerInitializer {

    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        val wrappedHandler = init.init(initData)
        return FinishedCoinLossHandler(initData.flag, initData.winningCoinsSum, wrappedHandler)
    }
}