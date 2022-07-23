package ru.rsreu.jackal.game.action_result_handling.initers

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.FinishedWithFightAndActionSkipHandler
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class FinishedWithFightActionSkipInitializer : CellActionResultHandlerInitializer {
    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return FinishedWithFightAndActionSkipHandler(
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