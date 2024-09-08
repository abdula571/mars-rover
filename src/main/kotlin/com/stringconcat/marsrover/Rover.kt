package com.stringconcat.marsrover

class Rover(
    x: Int,
    y: Int,
    var direction: Direction
) {

    var coordinate = Coordinate(x, y)

    fun move() {
        coordinate = when (direction) {
            Direction.SOUTH -> coordinate.decY()
            Direction.NORTH -> coordinate.incY()
            Direction.EAST -> coordinate.incX()
            Direction.WEST -> coordinate.decX()
        }
    }

    fun turnLeft() {
        direction = when (direction) {
            Direction.NORTH -> Direction.WEST
            Direction.WEST-> Direction.SOUTH
            Direction.SOUTH-> Direction.EAST
            Direction.EAST-> Direction.NORTH
        }
    }

    // turn right
}