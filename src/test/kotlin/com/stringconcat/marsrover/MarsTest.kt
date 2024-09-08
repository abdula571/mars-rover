import com.stringconcat.marsrover.Coordinate

//package com.stringconcat.marsrover
//
//import org.junit.jupiter.api.Test
//
//class MarsTest {
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
//
//
//     */
//    @Test
//    fun `integration test - option one - controller`() {
//        val commands = listOf(
//            "5 5",
//            "1 2 N",
//            "LMLMLMLMM",
//            "3 3 E",
//            "MMRMMRMRRM"
//        )
//        val executor = MarsConttoller()
//        commands.forEach { str ->  executor.execute(str) }
//
//        val coordinates = executor.getCoordinates()
//        coordinates shouldContainExactly listOf("1 3 N", "5 1 E")
//    }
//
//    @Test
//    fun `integration test - option two - use case`() {
//        val roverId = 1
//        val commands = listOf(
//            CreatePlatoCommand(5, 5),
//            LandRoverPlato(1, 2, North, roverId),
//            TurnLeft(roverId),
//            MoveCommand(roverId)
//        )
//
//        val useCase = RoverCommanderUseCase()
//        val coordinates = useCase.execute(commands)
//    }
//
//Набрести на доменную модель
//    @Test
//    fun `integration test - option three - domain`() {
//        val plateo = Plateo(5, 5)
//        val rover1 = Rover()
//
//        val dispatcher = Dispatcher(plateo)
//            dispatcher.landRover()
//
//        val rover1 = plateo.landRover(rover1, Coordinate(1, 2), North)
//        rover1.turnLeft()
//        rover1.move()
//            //..
//
//        val rover2 = plateo.landRover(3, 3, East)
//        rover2.turnLeft()
//        rover2.move()
//
//        rover1.coordinates() shouldBe ..
//
//
//    }
//}

// TESTS
// when rover lended on the correct coordinates then it returns current state
// the rover can`t be landed outside of plato
// the rover cannot be landed on occupied cell

// rover cannot be moved outside of plato (ровер буксует и не падает за небесную твердь)
// rover cannot be moved to occupied cell

// check corner cases
