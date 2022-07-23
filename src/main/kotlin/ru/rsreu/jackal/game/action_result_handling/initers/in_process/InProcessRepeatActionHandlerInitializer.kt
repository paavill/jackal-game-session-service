package ru.rsreu.jackal.game.action_result_handling.initers.in_process

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.in_process.InProcessRepeatActionHandler
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
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