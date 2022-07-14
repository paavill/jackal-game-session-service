package ru.rsreu.jackal.game

import org.springframework.stereotype.Component
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.Water

@Component
class GameStateMapper {
    fun map(game: Game) : InitDataResponse{
        val responseCells = game.field.cells.map { row ->
            row.map { cell ->
                if (cell.isClose) {
                    CellResponse(CellType.HIDDEN, 0, listOf(), 0)
                } else if(cell is Water && cell.sheep != null) {
                    val ship = cell.sheep!!
                    CellResponse(ship.cellType, 0, ship.pirates.map { pirate ->
                        pirate.number
                    }, 0)
                } else {
                    CellResponse(cell.cellType, 0, cell.pirates.map { pirate ->
                        pirate.number
                    }, 0)
                }
        } }
        return InitDataResponse(game.nextPlayer.uid, responseCells)
    }
}