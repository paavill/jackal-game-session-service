package ru.rsreu.jackal.game.action_result_handling.initers

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.InProcessRepeatActionHandler
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class InProcessRepeatActionHandlerInitializer(private val position: List<Position>) :
    CellActionResultHandlerInitializer {
    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return InProcessRepeatActionHandler(
            position,
            initData.flag,
            initData.newPosition,
            initData.sequence,
            initData.newCell,
            initData.substitutionCell,
        )
    }
}