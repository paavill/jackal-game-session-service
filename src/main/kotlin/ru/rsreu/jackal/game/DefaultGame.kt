package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.action.GameAction
import ru.rsreu.jackal.game.action.GameActionResult
import ru.rsreu.jackal.game.action.GameActionResultDirectionQuestion
import ru.rsreu.jackal.game.action.GameActionResultFinished
import ru.rsreu.jackal.game.action_result_handling.DirectionQuestionHandler
import ru.rsreu.jackal.game.action_result_handling.util.*
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

    private val directionVariants: MutableList<Position> = mutableListOf()

    private val piratesSkippingAction = mutableMapOf<Pirate, Int>()

    private val changedCellsSequence = mutableListOf<Cell>()

    private val sequence = mutableListOf<Cell>()

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
        sequence.add(pirate.cell!!)

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
                sequence.add(newCell)
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
                sequence,
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
            }
            counter--
        }
        if (counter == 0) {
            // TODO: 19.07.2022 Исключение зацикливания
            println("Зацикливание")
        }
        setNextPlayer()
        sequence.clear()
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
        if (diff.x + diff.y > 2 && directionVariantIndex == -1 ||
            directionVariantIndex != -1 && directionVariants[directionVariantIndex] != newCell.position ||
            newCell.position.x == 0 && newCell.position.y == 0 ||
            newCell.position.x == 12 && newCell.position.y == 12 ||
            newCell.position.x == 12 && newCell.position.y == 0 ||
            newCell.position.x == 0 && newCell.position.y == 12) {
            throw Exception("Нет возможности так ходить")
        }
    }

    private fun playerPirateNumberValidateOrThrow(player: Player, number: Int) {
        if (player.pirateTeam.getPirateByNumber(number) == null) {
            throw Exception("Нет пиратов с таким номером")
        }
    }

}