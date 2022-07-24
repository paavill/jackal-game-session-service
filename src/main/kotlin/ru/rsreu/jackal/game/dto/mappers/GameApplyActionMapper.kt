package ru.rsreu.jackal.game.dto.mappers

import org.springframework.stereotype.Component
import ru.rsreu.jackal.game.action.GameActionResult
import ru.rsreu.jackal.game.action.GameActionResultDirectionQuestion
import ru.rsreu.jackal.game.action.GameActionResultFinished
import ru.rsreu.jackal.game.action.GameActionResultWithAbleToAct
import ru.rsreu.jackal.game.dto.*
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.cells.abstracted.RotatedCell
import ru.rsreu.jackal.game.field.cells.finished.ShipCell
import ru.rsreu.jackal.game.field.cells.finished.WaterCell

// TODO: 21.07.2022 НАДО УБРАТЬ ДУБЛЕКАТЫ КОДА 
@Component
class GameApplyActionMapper {
    fun map(
        nextPlayer: Player,
        players: Map<Player, List<ShipCell>>,
        gameActionResult: GameActionResult
    ): ActionResponse {
        val playersResponse = players.map { (player, ships) ->
            PlayerResponse(
                player.id,
                player.number,
                PirateTeamResponse(
                    player.pirateTeam.getAll().map { pirate -> pirate.number },
                    player.pirateTeam.getAllKilled().map { pirate -> pirate.number }),
                ships.map { ship ->
                    CellResponse(
                        ship.cellType,
                        ship.position,
                        0,
                        ship.pirates.map { pirate -> pirate.number },
                        ship.coinsNumber
                    )
                }
            )
        }

        val changedCellsResponse = gameActionResult.data.map { cell ->
            if (cell is WaterCell && cell.ship != null) {
                val ship = cell.ship!!
                CellResponse(ship.cellType, cell.position, 0, ship.pirates.map { pirate ->
                    pirate.number
                }, ship.coinsNumber)
            } else if (cell is RotatedCell) {
                CellResponse(cell.cellType, cell.position, cell.rotation, cell.pirates.map { pirate ->
                    pirate.number
                }, cell.coinsNumber)
            } else {
                CellResponse(cell.cellType, cell.position, 0, cell.pirates.map { pirate ->
                    pirate.number
                }, cell.coinsNumber)
            }
        }

        val result = when (gameActionResult) {
            is GameActionResultFinished -> {
                ActionResponseFinished(
                    nextPlayer.id,
                    nextPlayer.number,
                    playersResponse,
                    changedCellsResponse
                )
            }
            is GameActionResultDirectionQuestion -> {
                ActionResponseDirectionQuestion(
                    nextPlayer.id,
                    nextPlayer.number,
                    playersResponse,
                    changedCellsResponse,
                    gameActionResult.directions
                )
            }
            is GameActionResultWithAbleToAct -> {
                ActionResponseFinishedWithAbleToAct(
                    nextPlayer.id,
                    nextPlayer.number,
                    playersResponse,
                    changedCellsResponse
                )
            }
            else -> {
                throw Exception()
            }
        }

        return result
    }
}