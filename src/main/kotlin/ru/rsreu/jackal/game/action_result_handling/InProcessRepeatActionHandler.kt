package ru.rsreu.jackal.game.action_result_handling

import ru.rsreu.jackal.game.Position
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
    ActionResultHandler {
    override fun handle() {
        val cell = sequence[sequence.size - 2]
        if (cell is HorseCell) {
            substitutionCell.cell = HorseCell(newCell.position)
            flag.boolean = false
        } else {
            newPosition.position = newCell.position.add(newCell.position.sub(cell.position))
        }
    }
}