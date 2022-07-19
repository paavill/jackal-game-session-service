package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

abstract class StoringPiratesCell(position: Position) : OpenableCell(position), PirateMoveableCell {

    final override var coinsNumber: Int = 0
        private set
    final override val pirates: MutableList<Pirate> = mutableListOf()

    override fun setPirate(pirate: Pirate): CellActionResultType {
        pirates.add(pirate)
        if (checkFight(pirate, pirates)) {
            return CellActionResultType.FINISHED_WITH_FIGHT
        }
        return CellActionResultType.FINISHED
    }

    override fun removePirate(pirate: Pirate): CellActionResultType {
        if (pirates.size != 0 && pirates.indexOf(pirate) != -1) {
            pirates.remove(pirate)
        }
        // TODO: 16.07.2022 Исключение нет такого пирата
        return CellActionResultType.FINISHED
    }

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResult {
        // TODO: 14.07.2022 исключение если идет на ту же ячейку
        val old = pirate.move(this)
        val oldMoveAble = old as PirateMoveableCell
        oldMoveAble.removePirate(pirate)
        val actionType = this.setPirate(pirate)
        super.applyAction(pirate, false) //всегда возвратит FINISHED; см. OpenAble
        return CellActionResult(actionType, null)
    }

    private fun checkFight(newPirate: Pirate, oldPirates: MutableList<Pirate>): Boolean {
        for (pirate in oldPirates) {
            if (newPirate.playerId != pirate.playerId) {
                return true
            }
        }
        return false
    }
}