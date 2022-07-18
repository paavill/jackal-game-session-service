package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.ActionResult
import ru.rsreu.jackal.game.ActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

abstract class CellWithThreePirates(position: Position) : StoringPiratesCell(position) {

    override fun setPirate(pirate: Pirate) : ActionResultType {
        if(pirates.size < 3) {
            return super.setPirate(pirate)
        }
        // TODO: 16.07.2022 Ичключение если слишком много пиратов
        return ActionResultType.FINISHED
    }

    override fun removePirate(pirate: Pirate) : ActionResultType {
        if (pirates.size != 0 && pirates.indexOf(pirate) != -1){
            return super.removePirate(pirate)
        }
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


    protected fun setAll(list: List<Pirate>) {
        list.forEach { pirate ->
            pirates.add(pirate)
            pirate.move(this)
        }
    }
}