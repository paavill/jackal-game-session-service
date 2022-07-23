package ru.rsreu.jackal.game.field.cells.finished

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.action_result_handling.initers.CellActionResultHandlerInitializer
import ru.rsreu.jackal.game.action_result_handling.initers.in_process.InProcessRepeatActionHandlerInitializer
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.field.cells.AbleSendToWater
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.abstracted.OnePirateStoringCell

class IceCell(position: Position) : OnePirateStoringCell(position), AbleSendToWater {
    override val cellType: CellType = CellType.ICE

    override fun applyAction(pirate: Pirate, needTakeCoins: Boolean): CellActionResultHandlerInitializer {
        super.applyAction(pirate, needTakeCoins)
        return InProcessRepeatActionHandlerInitializer()
    }
}