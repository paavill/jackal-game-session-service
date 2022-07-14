package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.field.cells.Cell

interface Field {
    val cells: List<List<Cell>>
}