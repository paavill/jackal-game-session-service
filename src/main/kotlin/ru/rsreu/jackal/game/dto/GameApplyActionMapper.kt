package ru.rsreu.jackal.game.dto

import org.springframework.stereotype.Component
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell

@Component
class GameApplyActionMapper {
    fun map(map: Map<Cell, Position>) : Map<CellResponse, Position> {
        return map.map { (cell, pos) ->
            CellResponse(cell.cellType, 0, cell.pirates.map {
                    pirate ->  pirate.number}, 0) to pos
        }.toMap()
    }
}