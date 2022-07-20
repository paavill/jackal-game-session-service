package ru.rsreu.jackal.game.field.factories.chests

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.finished.chests.ChestTwoCoin
import ru.rsreu.jackal.game.field.factories.CellFactory

class ChestTwoCoinFactory : CellFactory {
    override fun createCell(position: Position): Cell {
        return ChestTwoCoin(position)
    }
}