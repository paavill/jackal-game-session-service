package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.ActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.CellWithThreePirates

class Ship(private val player: Player, position: Position, private var water: Water) : CellWithThreePirates(position) {
    override val cellType: CellType = CellType.SHIP

    init {
        this.setAll(player.pirateTeam.getAll())
    }

    override fun setPirate(pirate: Pirate): ActionResultType {
        val result = super.setPirate(pirate)
        if (!player.pirateTeam.isPirateIn(pirate)) {
            super.removePirate(pirate)
            return ActionResultType.FINISHED_WITH_KILL
        }
        return result
    }

    fun move(newWater: Water): Water {
        val old = this.water
        this.water = newWater
        return old
    }
}