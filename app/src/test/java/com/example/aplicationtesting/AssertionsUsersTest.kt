package com.example.aplicationtesting

import org.junit.*
import org.junit.Assert.*

/****
 * Project: Fundamentos JUnit
 * From: com.cursosant.fundamentosjunit
 * Created by Alain Nicolás Tello on 14/12/21 at 8:54
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 */
class AssertionsUsersTest {

    private lateinit var bot: User

    companion object{
        private lateinit var juan: User

        @BeforeClass @JvmStatic
        fun setupCommon(){
            juan = User("Juan", 18, true)
            println("BeforeClass")
        }

        @AfterClass @JvmStatic
        fun tearDownCommon(){
            juan = User()
            println("AfterClass")
        }
    }

    @Before
    fun setup(){
        bot = User("8bit", 1, false)
        println("Beforesetup")
    }

    @After
    fun tearDown(){
        bot = User()
        println("AftertearDown")
    }

    @Test
    fun checkHumanTest() {
        val assertions = Assertions()
        assertFalse(assertions.checkHuman(bot))
        assertTrue(assertions.checkHuman(juan))
        println("checkHuman")
    }

    @Test
    fun checkNotNullUserTest(){
        assertNotNull(juan)
        println("checkNotNullUser")
    }

    @Test
    fun checkNotSameUsersTest(){
        assertNotSame(bot, juan)
        println("checkNotSameUsers")
    }

    @Test
    fun checkSameUsersTest(){
        val copyJuan = juan
        assertSame(copyJuan, juan)
        println("checkSameUsers")
    }
}

/*TODO EL BEFORE EJECUTA ANTES DE CADA UNO DE LOS TEST Y EL AFTER DESPUES DE CADA TEST POR LO CUAL SI
*  HAY VARIOS SE VAN A ESTAR REPITIENDO EN CADA UNO , Y EL BEFORE CLASSY EL AFTER CLASS SE REPITA AL INICIO Y AL FINAL
* UNA SOLA VEZ!!!!!!!11*/