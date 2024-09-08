package com.stringconcat.marsrover

import kotlin.coroutines.coroutineContext

sealed class Command

data class ConstraintPlatoCommand(val coordinate: Coordinate) : Command() {
    init {
        if (coordinate.x == 0 && coordinate.y == 0) {
            throw InvalidConstraintCoordinateException()
        }
    }
}

data class InitPositionCommand(
    val coordinate: Coordinate,
    var direction: Direction
) : Command()

data class MoveCommand(val subCommands: List<SubCommand>) : Command() {
    enum class SubCommand {
        TURN_LEFT,
        TURN_RIGHT,
        MOVE
    }
}