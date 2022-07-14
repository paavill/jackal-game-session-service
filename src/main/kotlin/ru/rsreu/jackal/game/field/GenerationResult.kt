package ru.rsreu.jackal.game.field

import ru.rsreu.jackal.game.Player
import ru.rsreu.jackal.game.field.cells.Sheep

data class GenerationResult(val field: Field, val ships: Map<Player, Sheep>)