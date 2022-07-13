package ru.rsreu.jackal.game.field

import ru.rsreu.jackal.game.Player
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.Sheep
import ru.rsreu.jackal.game.field.cells.Water

class Field(val field: List<List<Cell>>) {
     fun setShips(players: List<Player>) : Map<Player, Sheep> {
        var playerIndex = 0
        val ships = mutableMapOf<Player, Sheep>()
        field.forEachIndexed {
            y, cells -> {
                cells.forEachIndexed {
                    x, cell -> {
                        if(cell is Water && (x == 8 || y == 8)) {
                            if (playerIndex < players.size){
                                cell.sheep = Sheep(players[playerIndex])
                                ships[players[playerIndex]] = (cell.sheep!!)
                                playerIndex++
                            }
                        }
                    }
                }
            }
        }
         return ships.toMap()
    }
}