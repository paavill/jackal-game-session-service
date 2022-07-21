package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.action.GameAction
import ru.rsreu.jackal.game.action.GameActionResult
import ru.rsreu.jackal.game.action.GameActionResultDirectionQuestion
import ru.rsreu.jackal.game.action.GameActionResultFinished
import ru.rsreu.jackal.game.action_result_handling.DirectionQuestionHandler
import ru.rsreu.jackal.game.action_result_handling.util.BooleanWrapper
import ru.rsreu.jackal.game.action_result_handling.util.CellWrapper
import ru.rsreu.jackal.game.action_result_handling.util.InitDataTransferObject
import ru.rsreu.jackal.game.action_result_handling.util.PositionWrapper
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.DefaultGameField
import ru.rsreu.jackal.game.field.cells.Cell
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

        val flag = BooleanWrapper(true)
        var counter = 100
        playerPirateNumberValidate(nextPlayer, gameAction.pirateNumber)

        val pirate = nextPlayer.pirateTeam.getPirateByNumber(gameAction.pirateNumber)!!
        changedCellsSequence.add(pirate.cell!!)
        sequence.add(pirate.cell!!)

        var substitutionCell = CellWrapper(null)
        val newPosition = PositionWrapper(Position(gameAction.x, gameAction.y))
        while (flag.boolean && counter > 0) {
            var newCell = field.cells[newPosition.position.y][newPosition.position.x]

            if (substitutionCell.cell != null) {
                newCell = substitutionCell.cell!!
            }
            val result = newCell.applyAction(pirate, gameAction.needTakeCoin)
            if (substitutionCell.cell == null) {
                changedCellsSequence.add(newCell)
                sequence.add(newCell)
            }
            substitutionCell.cell = null

            val initData = InitDataTransferObject(
                flag,
                players,
                playersAndShips,
                piratesSkippingAction,
                changedCellsSequence,
                directionVariants,
                sequence,
                nextPlayer,
                pirate,
                newCell,
                substitutionCell,
                newPosition
            )
            val handler = result.init(initData)
            if (handler is DirectionQuestionHandler) {
                return GameActionResultDirectionQuestion(changedCellsSequence, directionVariants)
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

    private fun playerPirateNumberValidate(player: Player, number: Int) {
        if (player.pirateTeam.getPirateByNumber(number) == null) {
            // TODO: 14.07.2022 Исключение: если нет пирата с таким номером
            throw Exception("Не тот пират")
        }
    }

}