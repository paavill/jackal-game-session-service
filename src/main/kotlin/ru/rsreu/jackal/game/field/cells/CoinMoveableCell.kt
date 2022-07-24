package ru.rsreu.jackal.game.field.cells

interface CoinMoveableCell {
    fun setCoin(coinNumber: Int)
    fun removeCoin() : Int
}