package ru.rsreu.jackal.game.field

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.finished.ShipCell
import ru.rsreu.jackal.game.field.cells.finished.WaterCell

class DefaultGameField(cells: List<List<Cell>>) : Field {
    override val cells: List<List<Cell>> = cells
        get() {
            if (!isInitFinished){
                // TODO: 16.07.2022 Исключение если не инициализированно
            }
            return field
        }
    private var isInitFinished = false

    fun setShips(players: List<Player>) : Map<Player, ShipCell> {
        val ships = mutableMapOf<Player, ShipCell>()
        when (players.size) {
            1 -> {
                ships[players[0]] = setFirst(players, 0, 6, 0)
            }
            2 -> {
                ships[players[0]] = setFirst(players, 0, 6, 0)
                ships[players[1]] = setFirst(players, 1, 0, 6)
            }
            3 -> {
                ships[players[0]] = setFirst(players, 0, 6, 0)
                ships[players[1]] = setFirst(players, 1, 0, 6)
                ships[players[2]] = setFirst(players, 2, 6, 12)
            }
            4 -> {
                ships[players[0]] = setFirst(players, 0, 6, 0)
                ships[players[1]] = setFirst(players, 1, 0, 6)
                ships[players[2]] = setFirst(players, 2, 6, 12)
                ships[players[3]] = setFirst(players, 3, 12, 6)
            }
        }
        this.isInitFinished = true
        return ships.toMap()
    }

    private fun setFirst(players: List<Player>, playerIndex: Int, x: Int, y: Int) : ShipCell {
        (cells[y][x] as WaterCell).ship = ShipCell(players[playerIndex], Position(x, y), cells[y][x] as WaterCell)
        return (cells[y][x] as WaterCell).ship!!
    }

}