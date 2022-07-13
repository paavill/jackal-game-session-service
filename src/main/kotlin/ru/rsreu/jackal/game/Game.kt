package ru.rsreu.jackal.game

interface Game {
    fun applyAction(uid: String, action: Action)
}