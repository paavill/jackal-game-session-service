package ru.rsreu.jackal.game.action_result_handling.initers.finished

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.finished.FinishedWithFightAndActionSkipHandler
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class FinishedWithFightActionSkipInitializer(private val skipNumber: Int) : CellActionResultHandlerInitializer {
    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return FinishedWithFightAndActionSkipHandler(
            skipNumber,
            initData.players,
            initData.playersAndShips,
            initData.flag,
            initData.changedCellsSequence,
            initData.piratesSkippingAction,
            initData.nextPlayer,
            initData.pirate,
            initData.newCell
        )
    }
}