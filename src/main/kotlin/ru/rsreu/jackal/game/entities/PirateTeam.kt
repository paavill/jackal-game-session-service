package ru.rsreu.jackal.game.entities

class PirateTeam(pirate1: Pirate, pirate2: Pirate, pirate3: Pirate) {
    private val pirates: Map<Int, Pirate> = mapOf(
        Pair(pirate1.number, pirate1),
        Pair(pirate2.number, pirate2),
        Pair(pirate3.number, pirate3)
    )

    fun getPirateByNumber(number: Int) : Pirate {
        // TODO: 14.07.2022 при неправильном номере должна выкидываться ошибка 
        return pirates[number]!!
    }

    fun getAll() : List<Pirate> {
        return pirates.values.toList()
    }
}