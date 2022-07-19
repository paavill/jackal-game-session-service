package ru.rsreu.jackal.game.field.cells.action

enum class CellActionResultType {
    FINISHED,
    FINISHED_WITH_FIGHT,
    FINISHED_WITH_KILL,
    IN_PROCESS_WITH_TELEPORT_ON_SHIP,
    DIRECTION_QUESTION,
    IN_PROCESS
}