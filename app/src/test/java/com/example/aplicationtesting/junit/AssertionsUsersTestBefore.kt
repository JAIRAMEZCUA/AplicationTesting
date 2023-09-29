package com.example.aplicationtesting.junit

import com.example.aplicationtesting.junit.Assertions
import com.example.aplicationtesting.junit.User
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
class AssertionsUsersTestBefore {

    private lateinit var juan: User

    /*TODO BEFORE SE UTILIZA PARA INICILIZAR OBJETOS*/
    @Before
    fun setup() {
        juan = User("8bit", 1, true)
        println("Before")
    }

    @Test
    fun checkHumanTest() {
        val assertions = Assertions()
        assertTrue(assertions.checkHuman(juan))
        println("checkHuman")
    }

    /*TODO SE UTILIZA PARA LIMPIAR VARIABLES*/
    @After
    fun tearDown() {
        juan = User()
        println("After")
    }
}