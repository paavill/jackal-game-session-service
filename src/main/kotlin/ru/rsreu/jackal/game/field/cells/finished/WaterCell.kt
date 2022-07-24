package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.FinishedCoinLossHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.finished.FinishedHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.finished.FinishedWithAbleToActHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.AbleSendToWater
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.KillAbleByFightCell

class WaterCell(position: Position) : KillAbleByFightCell(position), AbleSendToWater {
    override val cellType: CellType = CellType.WATER
    override var isClose: Boolean = false
    var ship: ShipCell? = null

    override fun setCoin() {
        //Необходимо для отсутсвия функционала установки монеты
        if (ship != null) {
            ship!!.setCoin()
        }
    }

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResultHandlerInitializer {
        val current = pirate.cell
        if (current is ShipCell && this.ship == null) {
            val oldWater = current.move(this)
            oldWater.ship = null
            this.ship = current
        } else if (this.ship != null) {
            return this.ship!!.applyAction(pirate, needTakeCoins)
        } else if (current is AbleSendToWater) {
            return FinishedCoinLossHandlerInitializer(super.applyAction(pirate, needTakeCoins))
        } else {
            return FinishedWithAbleToActHandlerInitializer()
        }
        return FinishedHandlerInitializer()
    }

}