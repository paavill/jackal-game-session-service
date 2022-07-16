package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.factories.DefaultGameFactory
import ru.rsreu.jackal.game.factories.GameFactory

enum class GameMode(val factory: GameFactory) {
    DEFAULT(DefaultGameFactory())
}