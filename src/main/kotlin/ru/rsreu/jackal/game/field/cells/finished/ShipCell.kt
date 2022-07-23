package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.finished.FinishedWithKillHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.ThreePiratesStoringCell

class ShipCell(private val player: Player, position: Position, water: WaterCell) : ThreePiratesStoringCell(position) {
    override val cellType: CellType = CellType.SHIP
    override var position: Position = position
        private set
    var water = water
        private set

    init {
        this.setAll(player.pirateTeam.getAll())
    }

    override fun removeCoin() {
        //Должен быть пустым, чтобы нельзя было уносить монеты с корабля
    }

    override fun setPirate(pirate: Pirate): CellActionResultHandlerInitializer {
        val result = super.setPirate(pirate)
        if (!player.pirateTeam.isPirateIn(pirate)) {
            super.removePirate(pirate)
            return FinishedWithKillHandlerInitializer()
        }
        return result
    }

    fun move(newWater: WaterCell): WaterCell {
        val old = this.water
        this.water = newWater
        this.position = newWater.position
        return old
    }
}