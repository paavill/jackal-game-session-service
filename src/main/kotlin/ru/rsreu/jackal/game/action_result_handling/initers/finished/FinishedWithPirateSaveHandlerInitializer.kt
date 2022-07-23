package ru.rsreu.jackal.game.action_result_handling.initers.finished

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.finished.FinishedWithPirateSaveHandler
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject
import ru.rsreu.jackal.game.entities.Pirate

class FinishedWithPirateSaveHandlerInitializer(private val savedPirate: Pirate) : CellActionResultHandlerInitializer {
    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return FinishedWithPirateSaveHandler(initData.flag, initData.piratesSkippingAction, savedPirate)
    }
}