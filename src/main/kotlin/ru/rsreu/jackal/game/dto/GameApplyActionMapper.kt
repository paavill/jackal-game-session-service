package ru.rsreu.jackal.game.dto

import org.springframework.stereotype.Component
import ru.rsreu.jackal.game.action.GameActionResult
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.cells.Cell
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
        TODO()
        // TODO: 19.07.2022 Добавить два вида ActionResponse (с метаданными и без) 
        return ActionResponse(playersResponse, changedCellsResponse)
    }
}