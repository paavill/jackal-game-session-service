package ru.rsreu.jackal.game.action_result_handling.initers.finished

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.finished.FinishedWithPirateActionSkip
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class FinishedPirateToSkipHandlerInitializer(private val skipNumb: Int) : CellActionResultHandlerInitializer {
    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return FinishedWithPirateActionSkip(
            skipNumb,
            initData.flag,
            initData.nextPlayer,
            initData.pirate,
            initData.piratesSkippingAction
        )
    }
}