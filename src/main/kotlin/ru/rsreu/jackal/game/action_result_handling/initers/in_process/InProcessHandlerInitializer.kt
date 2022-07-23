package ru.rsreu.jackal.game.action_result_handling.initers.in_process

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.in_process.InProcessHandler
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class InProcessHandlerInitializer(val position: Position) : CellActionResultHandlerInitializer {
    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return InProcessHandler(
            position,
            initData.newPosition
        )
    }
}