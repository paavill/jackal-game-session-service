package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.action.GameAction
import ru.rsreu.jackal.game.action.GameActionResult
import ru.rsreu.jackal.game.action.GameActionResultFinished
import ru.rsreu.jackal.game.action.GameActionResultDirectionQuestion
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.DefaultGameField
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType
import ru.rsreu.jackal.game.field.cells.finished.ShipCell

class DefaultGame(
    private val players: Map<Long, Player>,
    override val field: DefaultGameField,
    private val playersAndShips: Map<Player, ShipCell>
) : Game {

    override var nextPlayer: Player = players.values.first()
        private set

    override fun getPlayersAndShips(): Map<Player, List<ShipCell>> {
        return playersAndShips.map { (player, ship) ->
            player to listOf<ShipCell>(ship)
        }.toMap()
    }

    override fun applyAction(gameAction: GameAction): GameActionResult {
        var flag = true
        var counter = 100
        val sequence = mutableListOf<Cell>()
        playerPirateNumberValidate(nextPlayer, gameAction.pirateNumber)

        val pirate = nextPlayer.pirateTeam.getPirateByNumber(gameAction.pirateNumber)!!
        sequence.add(pirate.cell!!)

        var newPosition = Position(gameAction.x, gameAction.y)
        while (flag) {
            val newCell = field.cells[newPosition.y][newPosition.x]
            val result = newCell.applyAction(pirate, gameAction.needTakeCoin)
            sequence.add(newCell)
            if (result.type == CellActionResultType.FINISHED) {
                flag = false
            } else if (result.type == CellActionResultType.FINISHED_WITH_FIGHT) {
                sequence.addAll(fight(pirate.playerId, newCell))
                flag = false
            } else if (result.type == CellActionResultType.FINISHED_WITH_KILL) {
                kill(pirate)
                flag = false
            } else if (result.type == CellActionResultType.IN_PROCESS) {
                newPosition = result.position!![0]
                // TODO: 19.07.2022 Проверка на наличие одного элемента, иначе исключение
            } else if (result.type == CellActionResultType.DIRECTION_QUESTION) {
                return GameActionResultDirectionQuestion(sequence, result.position!!)
                // TODO: 19.07.2022 Проверка на наличие листа, иначе исключение
            } else if (result.type == CellActionResultType.IN_PROCESS_WITH_TELEPORT_ON_SHIP) {
                newPosition = getPirateShip(pirate).position
            } else {
                if (counter < 0) {
                    // TODO: 19.07.2022 Исключение зацикливания
                }
            }
            counter--
        }
        setNextPlayer()
        return GameActionResultFinished(sequence.toList())
    }

    private fun setNextPlayer() {
        nextPlayer = if (players.values.indexOf(nextPlayer) + 1 < players.values.size) {
            players.values.toList()[players.values.indexOf(nextPlayer) + 1]
        } else {
            players.values.first()
        }

    }

    private fun kill(pirate: Pirate) {
        nextPlayer.pirateTeam.killPirate(pirate)
    }

    private fun getPirateShip(pirate: Pirate) : ShipCell {
        return playersAndShips[players[pirate.playerId]]!!
    }

    private fun fight(fightPiratePlayerId: Long, cell: Cell): List<Cell> {
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
            getPirateShip(pirate).applyAction(pirate, false)
            setOfChangedCells.add(getPirateShip(pirate))
        }
        return setOfChangedCells.toList()
    }

    private fun playerPirateNumberValidate(player: Player, number: Int) {
        if (player.pirateTeam.getPirateByNumber(number) == null) {
            // TODO: 14.07.2022 Исключение: если нет пирата с таким номером
            println("ошибка: не тот пират")
        }
    }

}