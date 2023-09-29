package com.example.aplicationtesting.junit

import com.example.aplicationtesting.junit.Assertions
import com.example.aplicationtesting.junit.User
import org.junit.*
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/****
 * Project: Fundamentos JUnit
 * From: com.cursosant.fundamentosjunit
 * Created by Alain Nicolás Tello on 14/12/21 at 11:19
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/

//TODO PASAMOS CADA USUARIO DE UNA LISTA
@RunWith(value = Parameterized::class)
class ParameterizedTest(var currentValue: Boolean, var currentUser: User) {

//    TODO aplicamos la regla de Es
    @get:Rule
    val locationESRule = LocationESRule()

    companion object{
        var assertions: Assertions? = null

        @BeforeClass @JvmStatic
        fun setupCommon(){
            assertions = Assertions()
        }
        @AfterClass
        @JvmStatic
        fun tearDownCommon(){
            assertions = null
        }

//        TODO ESPECIFICAMOS QUE LE VAMOS A PASAR A LA CLASE PARAMETRIZADA
//        TODO alimentamos la clase con los arrays, donde el primer elemeto es el esperado y el segundo nuestro objeto
        @Parameterized.Parameters @JvmStatic
        /*fun getUsersUS() = arrayOf(
            arrayOf(false, User("Pedro", 12)),
            arrayOf(true, User("Clara", 34)),
            arrayOf(true, User("Bot21", 4, false)),
            arrayOf(false, User("Alex", 18)))*/
        fun getUsersES() = arrayOf(
            arrayOf(true, User("Pedro", 19)),
            arrayOf(false, User("Clara", 14)),
            arrayOf(true, User("Bot21", 4, false)),
            arrayOf(true, User("Alex", 18)))
    }

    @Test
    fun isAdultTest() {
        //assertEquals(currentValue, assertions?.isAdult(currentUser))
        assertEquals(currentValue, locationESRule.assertions?.isAdult(currentUser))
    }

    @Test
    fun isHumanTest() {
//        assertEquals(currentValue, locationESRule.assertions?.checkHuman(currentUser))
    }
}