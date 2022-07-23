package ru.rsreu.jackal.game.action_result_handling.finished

import ru.rsreu.jackal.game.action_result_handling.FightableHandler
import ru.rsreu.jackal.game.action_result_handling.util.BooleanWrapper
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.finished.ShipCell

class FinishedWithFightHandler(
    players: Map<Long, Player>,
    playersAndShips: Map<Player, ShipCell>,
    flag: BooleanWrapper,
    changedCellsSequence: MutableList<Cell>,
    piratesSkippingAction: MutableMap<Pirate, Int>,
    pirate: Pirate, newCell: Cell
) : FightableHandler(players, playersAndShips, flag, changedCellsSequence, piratesSkippingAction, pirate, newCell)