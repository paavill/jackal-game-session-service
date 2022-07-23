package ru.rsreu.jackal.game.field.cells.abstracted

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.finished.FinishedHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.finished.FinishedWithFightHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CoinMoveableCell
import ru.rsreu.jackal.game.field.cells.PirateMoveableCell

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

    override fun setPirate(pirate: Pirate): CellActionResultHandlerInitializer {
        pirates.add(pirate)
        if (checkFight(pirate, pirates)) {
            return FinishedWithFightHandlerInitializer()
        }
        return FinishedHandlerInitializer()
    }

    override fun removePirate(pirate: Pirate): CellActionResultHandlerInitializer {
        if (pirates.size != 0 && pirates.indexOf(pirate) != -1) {
            pirates.remove(pirate)
        }
        // TODO: 16.07.2022 Исключение нет такого пирата
        return FinishedHandlerInitializer()
    }

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResultHandlerInitializer {
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
        return actionType
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