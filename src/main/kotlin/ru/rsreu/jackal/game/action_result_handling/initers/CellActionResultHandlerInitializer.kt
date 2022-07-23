package ru.rsreu.jackal.game.action_result_handling.initers

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

interface CellActionResultHandlerInitializer {
    fun init(
        initData: InitDataTransferObject
    ): ActionResultHandler
}