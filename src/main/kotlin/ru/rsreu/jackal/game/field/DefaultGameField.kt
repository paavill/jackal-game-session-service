package ru.rsreu.jackal.game.field

import ru.rsreu.jackal.game.Player
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.Sheep
import ru.rsreu.jackal.game.field.cells.Water

class DefaultGameField(val cells: List<List<Cell>>) {
    private var isInitFinished = false

    // TODO: 14.07.2022 Добавить метод получения ячейкии по координатам, сделав cells - private
    fun setShips(players: List<Player>) : Map<Player, Sheep> {
        var playerIndex = 0
        val ships = mutableMapOf<Player, Sheep>()
        cells.forEachIndexed {
                y, cells ->
            run {
                cells.forEachIndexed { x, cell ->
                    run {
                        if (cell is Water && (x == 8 || y == 8)) {
                            if (playerIndex < players.size) {
                                cell.sheep = Sheep(players[playerIndex])
                                ships[players[playerIndex]] = (cell.sheep!!)
                                playerIndex++
                            }
                        }
                    }
                }
            }
        }
        this.isInitFinished = true
        return ships.toMap()
    }
}