package ru.rsreu.jackal.game.field

import ru.rsreu.jackal.game.Field
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.Sheep
import ru.rsreu.jackal.game.field.cells.Water

class DefaultGameField(cells: List<List<Cell>>) : Field {
    override val cells: List<List<Cell>> = cells
        get() {
            if (!isInitFinished){
                // TODO: 16.07.2022 Исключение
            }
            return field
        }
    private var isInitFinished = false

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
                                cell.sheep = Sheep(players[playerIndex], cell.position.copy())
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