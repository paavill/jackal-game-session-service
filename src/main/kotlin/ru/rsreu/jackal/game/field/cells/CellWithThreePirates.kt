package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.ActionResult
import ru.rsreu.jackal.game.ActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

abstract class CellWithThreePirates(position: Position) : OpenableCell(position), PirateMoveAbleCell {

    final override val pirates: MutableList<Pirate> = mutableListOf()
    override fun setPirate(pirate: Pirate) : ActionResultType {
        if(pirates.size < 3) {
            pirates.add(pirate)
        }
        // TODO: 16.07.2022 Ичключение если слишком много пиратов
        return if (checkFight(pirate, pirates)) {
            ActionResultType.FINISHED_WITH_FIGHT
        } else {
            ActionResultType.FINISHED
        }
    }

    override fun removePirate(pirate: Pirate) : ActionResultType {
        if (pirates.size != 0 && pirates.indexOf(pirate) != -1){
            pirates.remove(pirate)
        }
        // TODO: 16.07.2022 Исключение нет такого пирата
        return ActionResultType.FINISHED
    }

    override fun applyAction(pirate: Pirate) : ActionResult {
        // TODO: 14.07.2022 исключение если идет на ту же ячейку
        val old = pirate.move(this)
        val oldMoveAble = old as PirateMoveAbleCell
        oldMoveAble.removePirate(pirate)
        val actionType = this.setPirate(pirate)
        return ActionResult(actionType, null)
    }

    private fun checkFight(newPirate: Pirate, oldPirates: MutableList<Pirate>) : Boolean {
        for (pirate in oldPirates) {
            if (newPirate.playerId != pirate.playerId) {
                return true
            }
        }
        return false
    }

    protected fun setAll(list: List<Pirate>) {
        list.forEach { pirate ->
            pirates.add(pirate)
            pirate.move(this)
        }
    }
}