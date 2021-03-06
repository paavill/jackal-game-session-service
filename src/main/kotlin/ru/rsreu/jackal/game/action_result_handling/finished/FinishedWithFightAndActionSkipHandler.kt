package ru.rsreu.jackal.game.action_result_handling.finished

import ru.rsreu.jackal.game.action_result_handling.FightableHandler
import ru.rsreu.jackal.game.action_result_handling.util.BooleanWrapper
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.finished.ShipCell

class FinishedWithFightAndActionSkipHandler(
    private val skipNumber: Int,
    players: Map<Long, Player>,
    playersAndShips: Map<Player, ShipCell>,
    private val flag: BooleanWrapper,
    changedCellsSequence: MutableList<Cell>,
    private val piratesSkippingAction: MutableMap<Pirate, Int>,
    private val nextPlayer: Player,
    private val pirate: Pirate, newCell: Cell
) : FightableHandler(players, playersAndShips, flag, changedCellsSequence, piratesSkippingAction, pirate, newCell) {
    override fun handle() {
        super.handle()
        piratesSkippingAction[pirate] = skipNumber
        flag.boolean = false
    }
}