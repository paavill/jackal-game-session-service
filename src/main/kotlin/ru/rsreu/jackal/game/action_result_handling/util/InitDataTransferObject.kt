package ru.rsreu.jackal.game.action_result_handling.util

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.finished.ShipCell

data class InitDataTransferObject(
    val flag: BooleanWrapper,
    val players: Map<Long, Player>,
    val playersAndShips: Map<Player, ShipCell>,
    val piratesSkippingAction: MutableMap<Player, Pirate>,
    val changedCellsSequence: MutableList<Cell>,
    val directionVariants: MutableList<Position>,
    val sequence: List<Cell>,
    val nextPlayer: Player,
    val pirate: Pirate,
    val newCell: Cell,
    val substitutionCell: CellWrapper,
    val newPosition: PositionWrapper
)