package ru.rsreu.jackal.game.action_result_handling.initers

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.FinishedWithPirateActionSkip
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class FinishedWithPirateActionSkipInitializer : CellActionResultHandlerInitializer {
    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return FinishedWithPirateActionSkip(
            initData.flag,
            initData.nextPlayer,
            initData.pirate,
            initData.piratesSkippingAction
        )
    }
}