package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.field.FieldGenerationService

enum class GameMode(val factory: GameFactory) {
    DEFAULT(DefaultGameFactory())
}