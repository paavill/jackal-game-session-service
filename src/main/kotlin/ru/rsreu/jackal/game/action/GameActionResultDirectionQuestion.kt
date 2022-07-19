package ru.rsreu.jackal.game.action

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.Cell

class GameActionResultDirectionQuestion(data: List<Cell>, val directions: List<Position>) : GameActionResult(data)