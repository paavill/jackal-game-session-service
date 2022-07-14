package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.DefaultGameField

interface Game {
    val field: DefaultGameField
    val nextPlayer: Player
    fun applyAction(action: Action)
}