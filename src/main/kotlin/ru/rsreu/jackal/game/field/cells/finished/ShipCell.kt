package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.field.cells.action.CellActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.ThreePiratesStoringCell

class ShipCell(private val player: Player, position: Position, private var water: WaterCell) : ThreePiratesStoringCell(position) {
    override val cellType: CellType = CellType.SHIP

    init {
        this.setAll(player.pirateTeam.getAll())
    }

    override fun setPirate(pirate: Pirate): CellActionResultType {
        val result = super.setPirate(pirate)
        if (!player.pirateTeam.isPirateIn(pirate)) {
            super.removePirate(pirate)
            return CellActionResultType.FINISHED_WITH_KILL
        }
        return result
    }

    fun move(newWater: WaterCell): WaterCell {
        val old = this.water
        this.water = newWater
        return old
    }
}