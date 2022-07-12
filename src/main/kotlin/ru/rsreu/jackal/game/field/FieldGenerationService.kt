package ru.rsreu.jackal.game.field

import org.springframework.stereotype.Service
import ru.rsreu.jackal.game.Player
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.CellType
import ru.rsreu.jackal.game.field.cells.EmptyCell
import kotlin.random.Random
import kotlin.random.nextInt

@Service
class FieldGenerationService {
    private val random: Random = Random.Default

    fun generate(players: Map<String, Player>) : List<List<Cell>>{
        val types = CellType.values()

        val field : List<List<Cell>> = List(11) {
            List(11) {
                EmptyCell()
            }
        }
        random.nextInt(0 until CellType.values().size)
        return field
    }
}