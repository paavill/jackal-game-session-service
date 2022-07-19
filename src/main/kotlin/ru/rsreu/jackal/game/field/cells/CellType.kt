package ru.rsreu.jackal.game.field.cells

import ru.rsreu.jackal.game.field.factories.CellFactory
import ru.rsreu.jackal.game.field.factories.EmptyCellFactory
import ru.rsreu.jackal.game.field.factories.StraightOneWayArrowCellFactory
import ru.rsreu.jackal.game.field.factories.StraightTwoWayArrowCellFactory

enum class CellType(val count: Int, val rotationNumber: Int, val skip: Int, val factory : CellFactory?) {
    HIDDEN(0, 0, 0, null),
    SHIP(0, 0, 0, null),
    WATER(0, 0, 0, null),
    EMPTY(40, 0, 0, EmptyCellFactory()),
    STRAIGHT_ONE_WAY_ARROW(3, 4, 0, StraightOneWayArrowCellFactory()),
    DIAGONAL_ONE_WAY_ARROW(3, 4, 0, EmptyCellFactory()),
    STRAIGHT_TWO_WAY_ARROW(3, 2, 0, StraightTwoWayArrowCellFactory()),
    DIAGONAL_TWO_WAY_ARROW(3, 2, 0, EmptyCellFactory()),
    STRAIGHT_CROSS_SHAPED_ARROW(3, 0, 0, EmptyCellFactory()),
    DIAGONAL_CROSS_SHAPED_ARROW(3, 0, 0, EmptyCellFactory()),
    DIAGONAL_Y_ARROW(3, 4, 0, EmptyCellFactory()),
    HORSE(2, 0, 0, EmptyCellFactory()),
    BARREL(4, 0, 0, EmptyCellFactory()),
    LABYRINTH_WOOD(5, 0, 1, EmptyCellFactory()), //-1 step
    LABYRINTH_SAND(4, 0, 2, EmptyCellFactory()), //-2
    LABYRINTH_JUNGLE(2, 0, 3, EmptyCellFactory()), //-3
    LABYRINTH_ROCKS(1, 0, 4, EmptyCellFactory()),//-4
    ICE(6, 0, 0, EmptyCellFactory()),
    TRAP(3, 0, 0, EmptyCellFactory()),
    CROCODILE(4, 0, 0, EmptyCellFactory()),
    CANNIBAL(1, 0, 0, EmptyCellFactory()),
    FORTRESS(2,0, 0, EmptyCellFactory()),
    NATIVE(1, 0, 0, EmptyCellFactory()),
    CHEST_1(5,0, 0, EmptyCellFactory()),
    CHEST_2(5, 0, 0, EmptyCellFactory()),
    CHEST_3(3, 0, 0, EmptyCellFactory()),
    CHEST_4(2, 0, 0, EmptyCellFactory()),
    CHEST_5(1, 0, 0, EmptyCellFactory()),
    BALL(2, 0, 0, EmptyCellFactory()),
    AIRPLANE(1, 0, 0, EmptyCellFactory()),
    GUN(2, 4, 0, EmptyCellFactory()),
}