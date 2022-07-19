package ru.rsreu.jackal.game

data class Position(val x: Int, val y: Int) {
    fun sub(position: Position): Position {
        return Position(x - position.x, y - position.y)
    }

    fun add(position: Position): Position {
        return sub(Position(-position.x, -position.y))
    }

}