package ru.rsreu.jackal.game.action_result_handling.initers.in_process

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.in_process.InProcessWithTeleportOnShipHandler
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject

class InProcessWithTeleportOnShipHandlerInitializer : CellActionResultHandlerInitializer {
    override fun init(initData: InitDataTransferObject): ActionResultHandler {
        return InProcessWithTeleportOnShipHandler(
            initData.newPosition,
            initData.players,
            initData.playersAndShips,
            initData.pirate
        )
    }
}