package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.field.factories.BallCellFactory
import ru.rsreu.jackal.game.field.factories.CellFactory
import ru.rsreu.jackal.game.field.factories.EmptyCellFactory
import ru.rsreu.jackal.game.field.factories.HorseCellFactory
import ru.rsreu.jackal.game.field.factories.arrows.*
import ru.rsreu.jackal.game.field.factories.chests.*

enum class CellType(val count: Int, val rotationNumber: Int, val skip: Int, val factory: CellFactory?) {
    HIDDEN(0, 0, 0, null),
    SHIP(0, 0, 0, null),
    WATER(0, 0, 0, null),
    EMPTY(40, 0, 0, EmptyCellFactory()),
    STRAIGHT_ONE_WAY_ARROW(3, 4, 0, StraightOneWayArrowCellFactory()),
    DIAGONAL_ONE_WAY_ARROW(3, 4, 0, DiagonalOneWayArrowCellFactory()),
    STRAIGHT_TWO_WAY_ARROW(3, 2, 0, StraightTwoWayArrowCellFactory()),
    DIAGONAL_TWO_WAY_ARROW(3, 2, 0, DiagonalTwoWayArrowCellFactory()),
    STRAIGHT_CROSS_SHAPED_ARROW(3, 0, 0, StraightCrossShapedArrowCellFactory()),
    DIAGONAL_CROSS_SHAPED_ARROW(3, 0, 0, DiagonalCrossShapedArrowCellFactory()),
    DIAGONAL_Y_ARROW(3, 4, 0, DiagonalYArrowCellFactory()),
    HORSE(2, 0, 0, HorseCellFactory()),
    BARREL(4, 0, 0, EmptyCellFactory()),
    LABYRINTH_WOOD(5, 0, 1, EmptyCellFactory()), //-1 step
    LABYRINTH_SAND(4, 0, 2, EmptyCellFactory()), //-2
    LABYRINTH_JUNGLE(2, 0, 3, EmptyCellFactory()), //-3
    LABYRINTH_ROCKS(1, 0, 4, EmptyCellFactory()),//-4
    ICE(6, 0, 0, EmptyCellFactory()),
    TRAP(3, 0, 0, EmptyCellFactory()),
    CROCODILE(4, 0, 0, EmptyCellFactory()),
    CANNIBAL(1, 0, 0, EmptyCellFactory()),
    FORTRESS(2, 0, 0, EmptyCellFactory()),
    NATIVE(1, 0, 0, EmptyCellFactory()),
    CHEST_1(5, 0, 0, ChestOneCoinFactory()),
    CHEST_2(5, 0, 0, ChestTwoCoinFactory()),
    CHEST_3(3, 0, 0, ChestThreeCoinFactory()),
    CHEST_4(2, 0, 0, ChestFourCoinFactory()),
    CHEST_5(1, 0, 0, ChestFiveCoinFactory()),
    BALL(2, 0, 0, BallCellFactory()),
    AIRPLANE(1, 0, 0, EmptyCellFactory()),
    GUN(2, 4, 0, EmptyCellFactory()),
}