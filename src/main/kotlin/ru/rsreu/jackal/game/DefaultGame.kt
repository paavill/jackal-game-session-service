package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.action.GameAction
import ru.rsreu.jackal.game.action.GameActionResult
import ru.rsreu.jackal.game.action.GameActionResultDirectionQuestion
import ru.rsreu.jackal.game.action.GameActionResultFinished
import ru.rsreu.jackal.game.action_result_handling.DirectionQuestionHandler
import ru.rsreu.jackal.game.action_result_handling.finished.FinishedWithAbleToActHandler
import ru.rsreu.jackal.game.action_result_handling.util.*
import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.DefaultGameField
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.finished.ShipCell
import kotlin.math.absoluteValue

class DefaultGame(
    private val players: Map<Long, Player>,
    override val field: DefaultGameField,
    private val playersAndShips: Map<Player, ShipCell>
) : Game {

    override var nextPlayer: Player = players.values.first()
        private set

    private val directionVariants: MutableList<Position> = mutableListOf()

    private val piratesSkippingAction = mutableMapOf<Pirate, Int>()

    private val changedCellsSequence = mutableListOf<Cell>()

    private val sequenceStopped = mutableListOf<Cell>()

    private val winningCoinsSum = IntWrapper(37) //По правилам

    override fun getPlayersAndShips(): Map<Player, List<ShipCell>> {
        return playersAndShips.map { (player, ship) ->
            player to listOf(ship)
        }.toMap()
    }

    override fun applyAction(gameAction: GameAction): GameActionResult {
        playerPirateNumberValidateOrThrow(nextPlayer, gameAction.pirateNumber)

        changedCellsSequence.clear()

        var counter = 100
        val flag = BooleanWrapper(true)
        val pirate = nextPlayer.pirateTeam.getPirateByNumber(gameAction.pirateNumber)!!

        changedCellsSequence.add(pirate.cell!!)
        sequenceStopped.add(pirate.cell!!)

        val substitutionCell = CellWrapper(null)
        val newPosition = PositionWrapper(Position(gameAction.x, gameAction.y))
        while (flag.boolean && counter > 0) {
            var newCell = field.cells[newPosition.position.y][newPosition.position.x]
            checkPossibilityToActOrThrow(pirate, newCell)

            if (substitutionCell.cell != null) {
                newCell = substitutionCell.cell!!
            }

            val result = newCell.applyAction(pirate, gameAction.needTakeCoin)

            if (substitutionCell.cell == null) {
                changedCellsSequence.add(newCell)
                sequenceStopped.add(newCell)
            } else {
                substitutionCell.cell = null
            }

            val initData = InitDataTransferObject(
                flag,
                players,
                playersAndShips,
                piratesSkippingAction,
                changedCellsSequence,
                directionVariants,
                sequenceStopped,
                nextPlayer,
                pirate,
                newCell,
                substitutionCell,
                newPosition,
                winningCoinsSum
            )

            val handler = result.init(initData)
            handler.handle()
            if (handler is DirectionQuestionHandler) {
                return GameActionResultDirectionQuestion(changedCellsSequence, directionVariants)
            } else if (handler is FinishedWithAbleToActHandler) {
                return GameActionResultFinished(changedCellsSequence)
            }
            counter--
        }
        if (counter == 0) {
            // TODO: 19.07.2022 Исключение зацикливания
            println("Зацикливание")
        }
        setNextPlayer()
        sequenceStopped.clear()
        return GameActionResultFinished(changedCellsSequence.toList())
    }

    override fun getPiratesSkippingAction(): List<Pirate> {
        return piratesSkippingAction.keys.toList()
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

    // TODO: 23.07.2022 Не привязываться к размерам поля для гибкости класса 
    private fun checkPossibilityToActOrThrow(pirate: Pirate, newCell: Cell) {
        val diff = pirate.cell!!.position.sub(newCell.position)
        val directionVariantIndex = directionVariants.indexOf(newCell.position)
        if (directionVariants.size > 0) {
            directionVariants.clear()
        }
        if ((diff.x.absoluteValue > 1 || diff.y.absoluteValue > 1) && directionVariantIndex == -1 ||
            newCell.position.x == 0 && newCell.position.y == 0 ||
            newCell.position.x == 12 && newCell.position.y == 12 ||
            newCell.position.x == 12 && newCell.position.y == 0 ||
            newCell.position.x == 0 && newCell.position.y == 12 ||
            newCell.position == pirate.cell!!.position
        ) {
            throw Exception("Нет возможности так ходить")
        }
    }

    private fun playerPirateNumberValidateOrThrow(player: Player, number: Int) {
        if (player.pirateTeam.getPirateByNumber(number) == null) {
            throw Exception("Нет пиратов с таким номером")
        }
    }

}