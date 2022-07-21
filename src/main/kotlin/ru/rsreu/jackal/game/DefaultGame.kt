package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.action.GameAction
import ru.rsreu.jackal.game.action.GameActionResult
import ru.rsreu.jackal.game.action.GameActionResultDirectionQuestion
import ru.rsreu.jackal.game.action.GameActionResultFinished
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.DefaultGameField
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.action.CellActionResultType
import ru.rsreu.jackal.game.field.cells.finished.HorseCell
import ru.rsreu.jackal.game.field.cells.finished.ShipCell

class DefaultGame(
    private val players: Map<Long, Player>,
    override val field: DefaultGameField,
    private val playersAndShips: Map<Player, ShipCell>
) : Game {

    override var nextPlayer: Player = players.values.first()
        private set

    private var directionVariants: MutableList<Position> = mutableListOf()

    private val piratesSkippingAction = mutableMapOf<Player, Pirate>()

    private val changedCellsSequence = mutableListOf<Cell>()

    private val sequence = mutableListOf<Cell>()

    private var winningCoinsSum = 37 //По правилам

    override fun getPlayersAndShips(): Map<Player, List<ShipCell>> {
        return playersAndShips.map { (player, ship) ->
            player to listOf(ship)
        }.toMap()
    }

    // TODO: 21.07.2022 ПРОСТО УБЕРИТЕ УЖЕ ЭТОТ IFELSE (есть идейка, но нет времени)
    override fun applyAction(gameAction: GameAction): GameActionResult {
        changedCellsSequence.clear()

        var flag = true
        var counter = 100
        playerPirateNumberValidate(nextPlayer, gameAction.pirateNumber)

        val pirate = nextPlayer.pirateTeam.getPirateByNumber(gameAction.pirateNumber)!!
        changedCellsSequence.add(pirate.cell!!)
        sequence.add(pirate.cell!!)

        var substitutionCell: Cell? = null
        var newPosition = Position(gameAction.x, gameAction.y)
        while (flag && counter > 0) {
            var newCell = field.cells[newPosition.y][newPosition.x]
            if (substitutionCell != null) {
                newCell = substitutionCell
            }
            val result = newCell.applyAction(pirate, gameAction.needTakeCoin)
            if (substitutionCell == null) {
                changedCellsSequence.add(newCell)
                sequence.add(newCell)
            }
            substitutionCell = null
            if (result.type == CellActionResultType.FINISHED) {
                flag = false
            } else if (result.type == CellActionResultType.FINISHED_WITH_FIGHT) {
                changedCellsSequence.addAll(fight(pirate.playerId, newCell))
                flag = false
            } else if (result.type == CellActionResultType.FINISHED_WITH_KILL) {
                kill(pirate)
                flag = false
            } else if (result.type == CellActionResultType.FINISHED_WITH_PIRATE_ACTION_SKIP) {
                val player = players[pirate.playerId]!!
                piratesSkippingAction[player] = pirate
                flag = false
            } else if (result.type == CellActionResultType.FINISHED_WITH_PIRATE_ACTION_SKIP_AND_FIGHT) {
                val player = players[pirate.playerId]!!
                piratesSkippingAction[player] = pirate
                changedCellsSequence.addAll(fight(pirate.playerId, newCell))
                flag = false
            } else if (result.type == CellActionResultType.IN_PROCESS) {
                newPosition = result.position!![0]
                // TODO: 19.07.2022 Проверка на наличие одного элемента, иначе исключение
            } else if (result.type == CellActionResultType.IN_PROCESS_REPEAT_ACTION) {
                val cell = sequence[sequence.size - 2]
                if (cell is HorseCell) {
                    substitutionCell = HorseCell(newCell.position)
                    flag = false
                } else {
                    newPosition = newCell.position.add(newCell.position.sub(cell.position))
                }
            } else if (result.type == CellActionResultType.DIRECTION_QUESTION) {
                directionVariants.addAll(result.position!!)
                return GameActionResultDirectionQuestion(changedCellsSequence, result.position)
                // TODO: 19.07.2022 Проверка на наличие листа, иначе исключение
            } else if (result.type == CellActionResultType.IN_PROCESS_WITH_TELEPORT_ON_SHIP) {
                newPosition = getPirateShip(pirate).position
            } else {

            }
            if (counter == 1) {
                // TODO: 19.07.2022 Исключение зацикливания
                println("Зацикливание")
            }
            counter--
        }
        setNextPlayer()
        sequence.clear()
        return GameActionResultFinished(changedCellsSequence.toList())
    }

    override fun getPiratesSkippingAction(): List<Pirate> {
        return piratesSkippingAction.values.toList()
    }

    private fun setNextPlayer() {
        nextPlayer = if (players.values.indexOf(nextPlayer) + 1 < players.values.size) {
            players.values.toList()[players.values.indexOf(nextPlayer) + 1]
        } else {
            players.values.first()
        }

    }

    private fun checkGameFinished(): Boolean {
        TODO()
    }

    private fun checkPossibilityToAct(pirate: Pirate, oldCell: Cell) {
        TODO()
    }

    private fun kill(pirate: Pirate) {
        nextPlayer.pirateTeam.killPirate(pirate)
    }

    private fun getPirateShip(pirate: Pirate): ShipCell {
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

    private fun playerPirateNumberValidate(player: Player, number: Int) {
        if (player.pirateTeam.getPirateByNumber(number) == null) {
            // TODO: 14.07.2022 Исключение: если нет пирата с таким номером
            throw Exception("Не тот пират")
        }
    }

}