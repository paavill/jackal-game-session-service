package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.FinishedCoinLossHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.FinishedHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.KillAbleByFightCell

class WaterCell(position: Position) : KillAbleByFightCell(position) {
    override val cellType: CellType = CellType.WATER
    override var isClose: Boolean = false
    var ship: ShipCell? = null

    override fun setCoin() {
        //Необходимо для отсутсвия функционала установки монеты
    }

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResultHandlerInitializer {
        val current = pirate.cell
        if (current is ShipCell && this.ship == null) {
            val oldWater = current.move(this)
            oldWater.ship = null
            this.ship = current
        } else if (this.ship != null) {
            return this.ship!!.applyAction(pirate, needTakeCoins)
        } else if (current !is EmptyCell) {
            // TODO: 17.07.2022 Надо определить с каких ячеек пират не может ходить на воду
            return super.applyAction(pirate, needTakeCoins)
        }
        if (needTakeCoins) {
            return FinishedCoinLossHandlerInitializer()
        }
        return FinishedHandlerInitializer()
    }

}