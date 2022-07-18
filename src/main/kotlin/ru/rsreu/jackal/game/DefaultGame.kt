package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.DefaultGameField
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.Ship

class DefaultGame(private val players: Map<String, Player>,
                  override val field: DefaultGameField,
                  val ships: Map<Player, Ship>) : Game {

    override var nextPlayer: Player = players.values.first()
        private set

    override fun applyAction(action: Action) : List<Cell>{
        var flag = true
        val seq = mutableListOf<Cell>()
        playerPirateNumberValidate(nextPlayer, action.pirateNumber)

        val pirate = nextPlayer.pirateTeam.getPirateByNumber(action.pirateNumber)!!
        seq.add(pirate.cell!!)

        var newPosition = Position(action.x, action.y)
        while (flag) {
            val newCell = field.cells[newPosition.y][newPosition.x]
            val result = newCell.applyAction(pirate)
            seq.add(newCell)
            if(result.type == ActionResultType.FINISHED) {
                flag = false
            } else if (result.type == ActionResultType.FINISHED_WITH_FIGHT) {
                seq.addAll(fight(pirate.playerId, newCell))
                flag = false
            } else {
                newPosition = result.position!!
            }
        }
        setNextPlayer()
        return seq.toList()
    }

    private fun setNextPlayer() {
        nextPlayer = if(players.values.indexOf(nextPlayer) + 1 < players.values.size) {
            players.values.toList()[players.values.indexOf(nextPlayer) + 1]
        } else {
            players.values.first()
        }

    }

    private fun fight(fightPiratePlayerId: String, cell: Cell) : List<Cell> {
        val toShip = mutableListOf<Pirate>()
        val setOfChangedCells = mutableSetOf<Cell>()
        //Удаление пиратов из ячейки
        cell.pirates.forEach { pirate ->
            if (pirate.playerId != fightPiratePlayerId) {
                toShip.add(pirate)
            }
        }
        //Отправка пиратов на их корабль
        toShip.forEach { pirate ->
            cell.pirates.remove(pirate)
            ships[players[pirate.playerId]]!!.pirates.add(pirate)
            setOfChangedCells.add(ships[players[pirate.playerId]]!!)
        }
        return setOfChangedCells.toList()
    }

    private fun getPiratePosition(pirate: Pirate) : Position {
        return pirate.cell!!.position
    }

    private fun playerPirateNumberValidate(player: Player,  number: Int) {
        if (player.pirateTeam.getPirateByNumber(number) == null) {
            // TODO: 14.07.2022 Исключение: если нет пирата с таким номером
            println("ошибка: не тот пират")
        }
    }

}