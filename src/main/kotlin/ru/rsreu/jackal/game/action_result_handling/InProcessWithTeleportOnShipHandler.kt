package ru.rsreu.jackal.game.action_result_handling

import ru.rsreu.jackal.game.action_result_handling.util.PositionWrapper
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.cells.finished.ShipCell

class InProcessWithTeleportOnShipHandler(
    private val newPosition: PositionWrapper,
    private val players: Map<Long, Player>,
    private val playersAndShips: Map<Player, ShipCell>,
    private val pirate: Pirate
) : ActionResultHandler {
    override fun handle() {
        newPosition.position = getPirateShip(pirate).position
    }

    private fun getPirateShip(pirate: Pirate): ShipCell {
        return playersAndShips[players[pirate.playerId]]!!
    }
}