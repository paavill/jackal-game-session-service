package ru.rsreu.jackal.game.field.cells

enum class CellType(val count: Int, val rotationNumber: Int, val skip: Int) {
    WATER(113, 0, 0),
    EMPTY(40, 0, 0),
    STRAIGHT_ONE_WAY_ARROW(3, 4, 0),
    DIAGONAL_ONE_WAY_ARROW(3, 4, 0),
    STRAIGHT_TWO_WAY_ARROW(3, 2, 0),
    DIAGONAL_TWO_WAY_ARROW(3, 2, 0),
    STRAIGHT_CROSS_SHAPED_ARROW(3, 0, 0),
    DIAGONAL_CROSS_SHAPED_ARROW(3, 0, 0),
    DIAGONAL_Y_ARROW(3, 4, 0),
    HORSE(2, 0, 0),
    BARREL(4, 0, 0),
    LABYRINTH_WOOD(5, 0, 1), //-1 step
    LABYRINTH_SAND(4, 0, 2), //-2
    LABYRINTH_JUNGLE(2, 0, 3), //-3
    LABYRINTH_ROCKS(1, 0, 4),//-4
    ICE(6, 0, 0),
    TRAP(3, 0, 0),
    CROCODILE(4, 0, 0),
    CANNIBAL(1, 0, 0),
    FORTRESS(2,0, 0),
    NATIVE(1, 0, 0),
    CHEST_1(5,0, 0),
    CHEST_2(5, 0, 0),
    CHEST_3(3, 0, 0),
    CHEST_4(2, 0, 0),
    CHEST_5(1, 0, 0),
    BALL(2, 0, 0),
    AIRPLANE(1, 0, 0),
    GUN(2, 4, 0),
}