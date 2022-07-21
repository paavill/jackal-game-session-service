package ru.rsreu.jackal.game.action_result_handling

import ru.rsreu.jackal.game.action_result_handling.util.BooleanWrapper
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.finished.ShipCell

abstract class FightableHandler(
    private val players: Map<Long, Player>,
    private val playersAndShips: Map<Player, ShipCell>,
    private val flag: BooleanWrapper,
    private val changedCellsSequence: MutableList<Cell>,
    private val piratesSkippingAction: MutableMap<Player, Pirate>,
    private val pirate: Pirate,
    private val newCell: Cell,
) : ActionResultHandler {

    override fun handle() {
        changedCellsSequence.addAll(fight())
        flag.boolean = false
    }

    private fun fight(): List<Cell> {
        val toShip = mutableListOf<Pirate>()
        val setOfChangedCells = mutableSetOf<Cell>()
        //Удаление пиратов из ячейки
        newCell.pirates.forEach { pirate ->
            if (pirate.playerId != this.pirate.playerId) {
                toShip.add(pirate)
            }
        }

        toShip.forEach { pirate ->
            if (piratesSkippingAction.values.toList().indexOf(pirate) != -1) {
                piratesSkippingAction.remove(players[pirate.playerId])
            }
        }

        //Отправка пиратов на их корабль
        toShip.forEach { pirate ->
            getPirateShip(pirate).applyAction(pirate, false)
            setOfChangedCells.add(getPirateShip(pirate))
        }
        return setOfChangedCells.toList()
    }

    // TODO: 21.07.2022 Подумать как убрать повтор 
    private fun getPirateShip(pirate: Pirate): ShipCell {
        return playersAndShips[players[pirate.playerId]]!!
    }
}