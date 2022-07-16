package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.ActionResult
import ru.rsreu.jackal.game.ActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

abstract class CellWithSixPirates(position: Position) : OpenableCell(position), PirateMovableCell {

    override val pirates: MutableList<Pirate> = mutableListOf()
    override fun setPirate(pirate: Pirate) {
        if(pirates.size < 6) {
            pirates.add(pirate)   
        }
        // TODO: 16.07.2022 Ичключение если слишком много пиратов
    }

    override fun removePirate(pirate: Pirate) {
        if (pirates.size != 0 && pirates.indexOf(pirate) != -1){
            pirates.remove(pirate)
        }
        // TODO: 16.07.2022 Исключение нет такого пирата
    }

    override fun applyAction(pirate: Pirate) : ActionResult{
        // TODO: 14.07.2022 исключение если идет на ту же ячейку
        val old = pirate.move(this)
        val oldMoveAble = old as PirateMovableCell
        oldMoveAble.removePirate(pirate)
        this.setPirate(pirate)
        super.applyAction(pirate)
        return ActionResult(ActionResultType.FINISHED, null)
    }

    protected fun setAll(list: List<Pirate>) {
        list.forEach { pirate ->
            pirates.add(pirate)
            pirate.move(this)
        }
    }
}