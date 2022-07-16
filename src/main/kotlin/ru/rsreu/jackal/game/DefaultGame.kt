package ru.rsreu.jackal.game

import ru.rsreu.jackal.game.entities.Pirate
import ru.rsreu.jackal.game.entities.Player
import ru.rsreu.jackal.game.field.DefaultGameField
import ru.rsreu.jackal.game.field.cells.Cell
import ru.rsreu.jackal.game.field.cells.Sheep
import ru.rsreu.jackal.game.field.cells.Water

class DefaultGame(private val players: Map<String, Player>,
                  override val field: DefaultGameField,
                  val ships: Map<Player, Sheep>) : Game {

    override var nextPlayer: Player = players.values.first()
        private set

    override fun applyAction(action: Action) : Map<Cell, Position>{
        playerPirateNumberValidate(nextPlayer, action.pirateNumber)
        val pirate = nextPlayer.pirateTeam.getPirateByNumber(action.pirateNumber)

        val seq = mutableMapOf<Cell, Position>()
        seq[pirate.cell!!] = pirate.cell!!.position
        var flag = true
        var newPosition = Position(action.x, action.y)

        while (flag) {
            val cell = field.cells[newPosition.y][newPosition.x]
            val result = cell.applyAction(pirate)
            seq[cell] = Position(newPosition.x, newPosition.y)
            if(result.type == ActionResultType.FINISHED){
                flag = false
            } else {
                newPosition = result.position!!
            }
        }
        return seq.toMap()
    }

    private fun getPiratePosition(pirate: Pirate) : Position {
        return pirate.cell!!.position
    }

    private fun playerPirateNumberValidate(player: Player,  number: Int) {
        player.pirateTeam.getPirateByNumber(number)
    }

}