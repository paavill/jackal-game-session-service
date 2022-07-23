package ru.rsreu.jackal.game.field.cells.abstracted

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.finished.FinishedHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate

abstract class ThreePiratesStoringCell(position: Position) : StoringPiratesCell(position) {
    override fun setPirate(pirate: Pirate): CellActionResultHandlerInitializer {
        if (pirates.size < 3) {
            return super.setPirate(pirate)
        }
        // TODO: 16.07.2022 Ичключение если слишком много пиратов
        return FinishedHandlerInitializer()
    }

    protected fun setAll(list: List<Pirate>) {
        list.forEach { pirate ->
            pirates.add(pirate)
            pirate.move(this)
        }
    }
}