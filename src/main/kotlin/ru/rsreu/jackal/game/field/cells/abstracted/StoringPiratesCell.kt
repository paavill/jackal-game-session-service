package ru.rsreu.jackal.game.field.cells.abstracted

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CoinMoveableCell
import ru.rsreu.jackal.game.field.cells.PirateMoveableCell
import ru.rsreu.jackal.game.field.cells.action.CellActionResult
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType

abstract class StoringPiratesCell(position: Position) : OpenableCell(position), PirateMoveableCell, CoinMoveableCell {

    override var coinsNumber: Int = 0
        protected set
    final override val pirates: MutableList<Pirate> = mutableListOf()

    override fun setCoin() {
        coinsNumber++
    }

    override fun removeCoin() {
        if (coinsNumber > 0) {
            coinsNumber--
        } else {
            // TODO: 19.07.2022
            throw Exception("Слишком мало монет")
        }
    }

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
        old as PirateMoveableCell
        old as CoinMoveableCell

        old.removePirate(pirate)
        if (needTakeCoins) {
            old.removeCoin()
        }
        val actionType = this.setPirate(pirate)
        if (needTakeCoins) {
            this.setCoin()
        }

        super.applyAction(pirate, false) //всегда возвратит FINISHED; см. Openable
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