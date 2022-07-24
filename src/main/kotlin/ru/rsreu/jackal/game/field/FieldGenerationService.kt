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
            val mutable = field.toMutableList()
            val firstRow = mutable[0]
            val secRow = mutable[1]
            val lastRow = mutable[12]
            val preLastRow = mutable[11]
            mutable.remove(firstRow)
            mutable.remove(secRow)
            mutable.remove(lastRow)
            mutable.remove(preLastRow)
            mutable.shuffle()
            mutable.add(0, firstRow)
            mutable.add(1, secRow)
            mutable.add(11, preLastRow)
            mutable.add(12, lastRow)
            return DefaultGameField(mutable.toList())
        }
    }

}