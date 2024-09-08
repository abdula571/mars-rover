package com.stringconcat.marsrover

data class Coordinate(
    val x: Int,
    val y: Int
) {
    init {
        if(x < 0 || y < 0) {
            throw InvalidCoordinateException()
        }
    }
    fun incX() = Coordinate(x.inc(), y)
    fun decX() = Coordinate(x.dec(), y)
    fun incY() = Coordinate(x, y.inc())
    fun decY() = Coordinate(x, y.dec())
}