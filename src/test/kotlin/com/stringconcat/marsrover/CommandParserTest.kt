package com.stringconcat.marsrover

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class CommandParserTest : FunSpec({
    val commandParser = CommandParser()

    context("command as string parsing as a ConstraintPlatoCommand") {
        withData(
            Pair("5 5", ConstraintPlatoCommand(Coordinate(5, 5))),
            Pair("5 6", ConstraintPlatoCommand(Coordinate(5, 6))),
            Pair("0 1", ConstraintPlatoCommand(Coordinate(0, 1)))
        ) { (inputString, expectedCommand) ->
            commandParser.parse(inputString) shouldBe expectedCommand
        }
    }

    context("An invalid command should not be parsed") {
        withData(
            "5",
            "2 3 4",
            "-1 -2",
            "0 0",
            "-1 1"
        ) { inputString ->
            shouldThrow<ParsingException> { commandParser.parse(inputString) }
        }
    }

    context("command as string parsed as a InitPositionCommand") {
        withData(
            Pair("1 2 N", InitPositionCommand(Coordinate(1, 2), Direction.NORTH)),
            Pair("5 3 E", InitPositionCommand(Coordinate(5, 3), Direction.EAST)),
            Pair("2 2 S", InitPositionCommand(Coordinate(2, 2), Direction.SOUTH)),
            Pair("4 7 W", InitPositionCommand(Coordinate(4, 7), Direction.WEST))
        ) { (inputString, expectedCommand) ->
            commandParser.parse(inputString) shouldBe expectedCommand
        }
    }
})