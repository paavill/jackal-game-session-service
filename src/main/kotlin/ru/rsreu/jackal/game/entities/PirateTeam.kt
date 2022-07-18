package ru.rsreu.jackal.game.entities

class PirateTeam(pirate1: Pirate, pirate2: Pirate, pirate3: Pirate) {
    private val pirates: Map<Int, Pirate> = mapOf(
        Pair(pirate1.number, pirate1),
        Pair(pirate2.number, pirate2),
        Pair(pirate3.number, pirate3)
    )

    private val killedPirates: MutableMap<Int, Pirate> = mutableMapOf()

    fun getPirateByNumber(number: Int) : Pirate? {
        // TODO: 19.07.2022 Исключение: в случае если пират мертв
        return pirates[number]
    }

    fun revivePirate() : Pirate? {
        val keys = killedPirates.keys.toList()
        if (keys.isNotEmpty()) {
            return killedPirates.remove(keys[0])
        }
        return null
    }

    fun killPirate(pirate: Pirate) {
        killedPirates[pirate.number] = pirate
    }

    fun isPirateKilled(pirate1: Pirate) {

    }

    fun isPirateIn(pirate: Pirate) : Boolean {
        return pirates[pirate.number] != null
    }

    fun getAll() : List<Pirate> {
        return pirates.values.toList()
    }

    fun getAllKilled() : List<Pirate> {
        return killedPirates.values.toList()
    }
}