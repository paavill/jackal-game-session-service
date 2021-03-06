package ru.rsreu.jackal.game.field

import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.field.cells.*
import ru.rsreu.jackal.game.field.cells.finished.WaterCell
import kotlin.random.Random
import kotlin.random.nextInt
class FieldGenerationService private constructor(){
    companion object {
        private val random: Random = Random.Default
        fun generate() : DefaultGameField {
            val counters = mutableMapOf(*CellType.values().map { type -> type to type.count }.toTypedArray())
            val types = CellType.values()
            var globalCounter = 117

            val field : List<List<Cell>> = List(13) { y ->
                List(13) { x ->
                    if ( ((x == 1 || x == 11) && (y == 1 || y == 11)) ||
                        ( x == 0 || x == 12 || y == 0 || y == 12) ) {
                        WaterCell(Position(x, y))
                    } else {
                        var ind = random.nextInt(types.indices)
                        while (counters[types[ind]] == 0 && globalCounter > 0){
                            ind = random.nextInt(types.indices)
                        }
                        val count = counters[types[ind]]!!
                        counters[types[ind]] = count - 1
                        globalCounter--
                        types[ind].factory!!.createCell(Position(x, y))
                    }
                }
            }
            field.forEach { row ->
                print("[ ")
                row.forEach { cell ->
                    print(" | " + String.format("%35s", cell.cellType.toString() + " " + cell.position.toString()) + " | ")
                }
                println(" ]")
            }
            return DefaultGameField(field)
        }
    }

}