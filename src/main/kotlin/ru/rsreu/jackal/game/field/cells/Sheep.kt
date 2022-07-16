package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.ActionResult
import ru.rsreu.jackal.game.ActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player

class Sheep(player: Player, position: Position) : CellWithSixPirates(position) {
    override val cellType: CellType = CellType.SHEEP
    init {
        this.setAll(player.pirateTeam.getAll())
    }
    override fun applyAction(pirate: Pirate) : ActionResult {
        super.applyAction(pirate)
        return ActionResult(ActionResultType.FINISHED, null)
    }
}