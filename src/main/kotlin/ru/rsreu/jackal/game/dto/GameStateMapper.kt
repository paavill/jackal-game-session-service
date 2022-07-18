package ru.rsreu.jackal.game.dto

import org.springframework.stereotype.Component
import ru.rsreu.jackal.game.Game
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.finished.Water

@Component
class GameStateMapper {
    fun map(game: Game) : InitDataResponse {
        val responseCells = game.field.cells.map { row ->
            row.map { cell ->
                if (cell.isClose) {
                    CellResponse(CellType.HIDDEN, cell.position, 0, listOf(), 0)
                } else if(cell is Water && cell.ship != null) {
                    val ship = cell.ship!!
                    CellResponse(ship.cellType, cell.position,0, ship.pirates.map { pirate ->
                        pirate.number
                    }, 0)
                } else {
                    CellResponse(cell.cellType, cell.position, 0, cell.pirates.map { pirate ->
                        pirate.number
                    }, 0)
                }
        } }
        return InitDataResponse(game.nextPlayer.uid, game.nextPlayer.number, responseCells)
    }
}