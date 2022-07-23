package ru.rsreu.jackal.game.field.cells.abstracted

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.finished.FinishedHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate

abstract class OnePirateStoringCell(position: Position) : StoringPiratesCell(position) {

    override fun setPirate(pirate: Pirate): CellActionResultHandlerInitializer {
        if (pirates.size < 1) {
            return super.setPirate(pirate)
        } else {
            throw Exception("Слишком много пиратов pos: " + this.position.toString())
        }
        // TODO: 16.07.2022 Ичключение если слишком много пиратов (сделать кастомное)
        return FinishedHandlerInitializer()
    }

}