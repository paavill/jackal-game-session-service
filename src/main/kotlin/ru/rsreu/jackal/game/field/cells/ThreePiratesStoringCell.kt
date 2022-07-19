package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.field.cells.action.CellActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

abstract class ThreePiratesStoringCell(position: Position) : StoringPiratesCell(position) {

    override fun setPirate(pirate: Pirate): CellActionResultType {
        if (pirates.size < 3) {
            return super.setPirate(pirate)
        }
        // TODO: 16.07.2022 Ичключение если слишком много пиратов
        return CellActionResultType.FINISHED
    }




    protected fun setAll(list: List<Pirate>) {
        list.forEach { pirate ->
            pirates.add(pirate)
            pirate.move(this)
        }
    }
}