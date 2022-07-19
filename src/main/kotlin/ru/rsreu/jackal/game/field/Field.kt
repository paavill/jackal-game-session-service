package ru.rsreu.jackal.game.field

import ru.rsreu.jackal.game.field.cells.Cell

interface Field {
    val cells: List<List<Cell>>
}