package ru.rsreu.jackal.game.action

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

data class GameAction(
    @field:Min(0)
    val pirateNumber: Int,
    @field:NotNull
    val needTakeCoin: Boolean,
    @field:Min(0)
    @field:Max(12)
    val x: Int,
    @field:Min(0)
    @field:Max(12)
    val y: Int
)