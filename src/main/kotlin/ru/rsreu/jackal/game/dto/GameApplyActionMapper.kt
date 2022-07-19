package ru.rsreu.jackal.game.dto

import org.springframework.stereotype.Component
import ru.rsreu.jackal.game.action.GameActionResult
import ru.rsreu.jackal.game.action.GameActionResultDirectionQuestion
import ru.rsreu.jackal.game.action.GameActionResultFinished
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.cells.finished.Ship
import ru.rsreu.jackal.game.field.cells.finished.Water

@Component
class GameApplyActionMapper {
    fun map(players: Map<Player, List<Ship>>, gameActionResult: GameActionResult): ActionResponse {
        val playersResponse = players.map { (player, ships) ->
            PlayerResponse(
                player.uid,
                player.number,
                PirateTeamResponse(
                    player.pirateTeam.getAll().map { pirate -> pirate.number },
                    player.pirateTeam.getAllKilled().map { pirate -> pirate.number }),
                ships.map { ship ->
                    CellResponse(ship.cellType, ship.position, 0, ship.pirates.map { pirate -> pirate.number }, 0)
                }
            )
        }

        val changedCellsResponse = gameActionResult.data.map { cell ->
            if (cell is Water && cell.ship != null) {
                val ship = cell.ship!!
                CellResponse(ship.cellType, cell.position, 0, ship.pirates.map { pirate ->
                    pirate.number
                }, 0)
            } else {
                CellResponse(cell.cellType, cell.position, 0, cell.pirates.map { pirate ->
                    pirate.number
                }, 0)
            }
        }

        val result = when (gameActionResult) {
            is GameActionResultFinished -> {
                ActionResponseFinished(playersResponse, changedCellsResponse)
            }
            is GameActionResultDirectionQuestion -> {
                ActionResponseDirectionQuestion(
                    playersResponse,
                    changedCellsResponse,
                    gameActionResult.directions
                )
            }
            else -> {
                throw Exception()
            }
        }

        return result
    }
}