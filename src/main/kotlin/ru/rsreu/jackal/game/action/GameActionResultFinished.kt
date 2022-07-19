package ru.rsreu.jackal.game.action

import ru.rsreu.jackal.game.field.cells.Cell

class GameActionResultFinished(data: List<Cell>) : GameActionResult(data) {
    override val resultType: GameActionResultType = GameActionResultType.FINISHED
}