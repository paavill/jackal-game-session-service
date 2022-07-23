package ru.rsreu.jackal.game.action_result_handling.initers.finished

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.finished.FinishedWithFightHandler
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class FinishedWithFightHandlerInitializer : CellActionResultHandlerInitializer {
    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return FinishedWithFightHandler(
            initData.players,
            initData.playersAndShips,
            initData.flag,
            initData.changedCellsSequence,
            initData.piratesSkippingAction,
            initData.pirate,
            initData.newCell
        )
    }
}