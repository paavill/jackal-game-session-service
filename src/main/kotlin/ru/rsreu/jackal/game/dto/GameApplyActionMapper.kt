package ru.rsreu.jackal.game.dto

import org.springframework.stereotype.Component
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.Water

@Component
class GameApplyActionMapper {
    fun map(map: List<Cell>) : List<CellResponse> {
        return map.map { cell ->
            if(cell is Water && cell.ship != null) {
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
    }
}