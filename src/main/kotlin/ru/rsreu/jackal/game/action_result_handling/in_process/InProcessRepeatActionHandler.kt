package ru.rsreu.jackal.game.action_result_handling.in_process

import ru.rsreu.jackal.game.action_result_handling.ActionResultHandler
import ru.rsreu.jackal.game.action_result_handling.util.BooleanWrapper
import ru.rsreu.jackal.game.action_result_handling.util.CellWrapper
import ru.rsreu.jackal.game.action_result_handling.util.PositionWrapper
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.finished.HorseCell

class InProcessRepeatActionHandler(
    private val flag: BooleanWrapper,
    private val newPosition: PositionWrapper,
    private val sequence: List<Cell>,
    private val newCell: Cell,
    private val substitutionCell: CellWrapper
) :
    ActionResultHandler, InProcess {
    override fun handle() {
        var cell = sequence[1]
        if (cell is HorseCell) {
            substitutionCell.cell = HorseCell(newCell.position)
        } else {
            cell = sequence[sequence.size - 2]
            newPosition.position = newCell.position.add(newCell.position.sub(cell.position))
        }
    }
}