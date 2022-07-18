package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.ActionResultType
import ru.rsreu.jackal.game.Position
import ru.rsreu.jackal.game.entities.Pirate

abstract class StoringPiratesCell(position: Position) : OpenableCell(position), PirateMoveAbleCell {

    final override val pirates: MutableList<Pirate> = mutableListOf()

    override fun setPirate(pirate: Pirate): ActionResultType {
        pirates.add(pirate)
        if (checkFight(pirate, pirates)) {
            return ActionResultType.FINISHED_WITH_FIGHT
        }
        return ActionResultType.FINISHED
    }

    override fun removePirate(pirate: Pirate): ActionResultType {
        if (pirates.indexOf(pirate) != -1) {
            pirates.remove(pirate)
        }
        // TODO: 16.07.2022 Исключение нет такого пирата
        return ActionResultType.FINISHED
    }

    private fun checkFight(newPirate: Pirate, oldPirates: MutableList<Pirate>) : Boolean {
        for (pirate in oldPirates) {
            if (newPirate.playerId != pirate.playerId) {
                return true
            }
        }
        return false
    }
}