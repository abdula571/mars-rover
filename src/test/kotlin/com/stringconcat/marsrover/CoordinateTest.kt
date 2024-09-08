package com.stringconcat.marsrover

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

class CoordinateTest: FunSpec({

    test("two coordinates are equal if values are the same") {
        Coordinate(0, 0) shouldBe Coordinate(0, 0)
        Coordinate(1, 0) shouldBe Coordinate(1, 0)
    }

    test("two coordinates are not equal if values are NOT the same") {
        Coordinate(0, 0) shouldNotBe Coordinate(99, 0)
        Coordinate(1, 0) shouldNotBe Coordinate(0, 99)
    }

    test("when call incX, decX, incY, decY then coordinate should be changed") {
        Coordinate(1, 0).incX() shouldBe Coordinate(2, 0)
        Coordinate(1, 0).decX() shouldBe Coordinate(0, 0)
        Coordinate(0, 1).decY() shouldBe Coordinate(0, 0)
        Coordinate(0, 1).incY() shouldBe Coordinate(0, 2)
    }

    context("throw InvalidCoordinateException when coordinate value negative") {
        withData(
            Pair(-1, 0),
            Pair(0, -1),
            Pair(-1, -1)
        ) { (x: Int, y: Int) ->
            shouldThrow<InvalidCoordinateException> { Coordinate(x, y) }
        }
    }
})