package com.stringconcat.marsrover

import com.stringconcat.marsrover.Direction.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class RoverTest : FunSpec({

    context("when rover stays on a coordinate then it can return the same coordinate") {
        val rover = Rover(3, 4, NORTH)
        rover.coordinate shouldBe Coordinate(3, 4)
        rover.direction shouldBe NORTH
    }

    context("when rover moves then it moves forward") {
        withData(
            Pair(Coordinate(5, 6), NORTH),
            Pair(Coordinate(6, 5), EAST),
            Pair(Coordinate(5, 4), SOUTH),
            Pair(Coordinate(4, 5), WEST)
        ) { (expectedCoordinate, direction) ->
            val rover = Rover(5, 5, direction)
            rover.move()
            rover.coordinate shouldBe expectedCoordinate
            rover.direction shouldBe direction
        }
    }

    context("when rover turns left then it turns left") {
        withData(
            Pair(NORTH, WEST),
            Pair(EAST, NORTH),
            Pair(SOUTH, EAST),
            Pair(WEST, SOUTH)
        ) { (startDirection, expectedDirection) ->
            val rover = Rover(0, 0, startDirection)
            rover.turnLeft()
            rover.direction shouldBe expectedDirection
        }
    }

    context("when rover turns right then it turns right") {
        withData(
            Pair(NORTH, EAST),
            Pair(EAST, SOUTH),
            Pair(SOUTH, WEST),
            Pair(WEST, NORTH)
        ) { (startDirection, expectedDirection) ->
            val rover = Rover(0, 0, startDirection)
            rover.turnRight()
            rover.direction shouldBe expectedDirection
        }
    }
})