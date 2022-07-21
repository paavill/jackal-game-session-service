package ru.rsreu.jackal.game.action_result_handling.initers

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.InProcessWithTeleportOnShipHandler
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