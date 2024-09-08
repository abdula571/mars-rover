package com.stringconcat.marsrover

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe


class MarsTest : FunSpec({

    context("integration test - option one - controller") {
//        val commands = listOf(
//            "5 5",
//            "1 2 N",
//            "LMLMLMLMM",
//            "3 3 E",
//            "MMRMMRMRRM"
//        )
//        val executor = MarsController()
//        commands.forEach { str ->  executor.execute(str) }
//
//        val coordinates = executor.getCoordinates()
//        coordinates shouldContainExactly listOf("1 3 N", "5 1 E")
    }


})

// TESTS
// when rover lended on the correct coordinates then it returns current state
// the rover can`t be landed outside of plato
// the rover cannot be landed on occupied cell

// rover cannot be moved outside of plato (ровер буксует и не падает за небесную твердь)
// rover cannot be moved to occupied cell

// check corner cases

//
//    /*
//    Пример тестового ввода:
//5 5 ← верхний правый угол плато
//1 2 N ← текущее положение и направление камеры первого марсохода
//LMLMLMLMM ← управление положением первого марсохода
//3 3 E ← текущее положение и направление камеры второго марсохода
//MMRMMRMRRM ← управление положением второго марсохода
//
//Пример тестового вывода:
//1 3 N ← конечное положение и направление камеры первого марсохода
//5 1 E ← конечное положение и направление камеры второго марсохода\