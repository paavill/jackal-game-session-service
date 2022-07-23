package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.in_process.InProcessRepeatActionHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.OnePirateStoringCell

class BallCell(position: Position) : OnePirateStoringCell(position) {
    override val cellType: CellType = CellType.BALL

    override fun setPirate(pirate: Pirate): CellActionResultHandlerInitializer {
        super.setPirate(pirate)
        return InProcessRepeatActionHandlerInitializer()
    }

}