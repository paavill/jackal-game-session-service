package ru.rsreu.jackal.game.action_result_handling.initers

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.FinishedCoinLossHandler
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class FinishedCoinLossHandlerInitializer : CellActionResultHandlerInitializer {

    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return FinishedCoinLossHandler(initData.flag, initData.winningCoinsSum)
    }
}