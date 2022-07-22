package ru.rsreu.jackal.game.action_result_handling.initers

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.InProcessRepeatActionHandler
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class InProcessRepeatActionHandlerInitializer :
    CellActionResultHandlerInitializer {
    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return InProcessRepeatActionHandler(
            initData.flag,
            initData.newPosition,
            initData.sequence,
            initData.newCell,
            initData.substitutionCell,
        )
    }
}