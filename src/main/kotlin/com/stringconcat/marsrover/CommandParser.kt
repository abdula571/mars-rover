package com.stringconcat.marsrover

class CommandParser {

    fun parse(inputString: String): Command {

        parseAsConstraintPlatoCommand(inputString)?.let { return it }
        parseAsInitPositionCommand(inputString)?.let { return it }

        throw ParsingException()
    }

    private fun parseAsConstraintPlatoCommand(inputString: String): Command? {
        val template = "^\\d+ \\d+$".toRegex()

        if (!template.matches(inputString)) {
            return null
        }

        val parts = inputString.split(" ").map { it.toInt() }

        try {
            return ConstraintPlatoCommand(Coordinate(parts.first(), parts.last()))
        } catch (_: InvalidConstraintCoordinateException) {
            throw ParsingException()
        } catch (_: InvalidCoordinateException) {
            throw ParsingException()
        }
    }

    private fun parseAsInitPositionCommand(inputString: String): Command? {
        val template = "^\\d+ \\d+ [NESW]$".toRegex()

        if (!template.matches(inputString)) {
            return null
        }

        val parts = inputString.split(" ")

        try {
            val coordinate = Coordinate(parts[0].toInt(), parts[1].toInt())
            val direction = when (parts[2]) {
                "N" -> Direction.NORTH
                "E" -> Direction.EAST
                "S" -> Direction.SOUTH
                "W" -> Direction.WEST
                else -> throw ParsingException()
            }

            return InitPositionCommand(coordinate, direction)
        } catch (_: InvalidCoordinateException) {
            throw ParsingException()
        }
    }

    private fun parseAsMoveCommand(inputString: String): Command? {
        return null
    }
}
