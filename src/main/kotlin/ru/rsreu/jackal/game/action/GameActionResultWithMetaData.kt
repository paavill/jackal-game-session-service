package ru.rsreu.jackal.game.action

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell

class GameActionResultWithMetaData(data: List<Cell>, val metaData: List<Position>) : GameActionResult(data) {
    override val resultType: GameActionResultType = GameActionResultType.DIRECTION_QUESTION
}