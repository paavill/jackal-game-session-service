package ru.rsreu.jackal.game.action_result_handling.initers

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.FinishedWithKillHandler
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class FinishedWithKillHandlerInitializer : CellActionResultHandlerInitializer {
    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return FinishedWithKillHandler(initData.flag, initData.pirate, initData.nextPlayer)
    }
}