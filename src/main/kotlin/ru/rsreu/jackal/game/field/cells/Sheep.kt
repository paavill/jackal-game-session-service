package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player

class Sheep(player: Player) : CellWithThreePirates() {
    override val cellType: CellType = CellType.SHEEP
    init {
        this.setAll(player.pirateTeam.getAll())
    }
    override fun applyAction(pirate: Pirate, current: Cell) {
        super.applyAction(pirate, current)
    }
}