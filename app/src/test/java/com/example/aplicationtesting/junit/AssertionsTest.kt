package com.example.aplicationtesting.junit

import org.junit.Assert.*
import org.junit.Test

class AssertionsTest {
    @Test
    fun getArrayTest() {
        val assertions = Assertions()
        val array = arrayOf(21, 117)
        val arrayFail = arrayOf(21, 11)
        assertArrayEquals(array, assertions.getLuckyNumbers())
        //TODO mandara el mensaje porque la comparacion no es igual
//        assertArrayEquals("Error en  arreglo", arrayFail, assertions.getLuckyNumbers())
//        var arraysAreEqual = true
//        if (expectedArray.length !== actualArray.length) {
//            arraysAreEqual = false
//        } else {
//            for (i in 0 until expectedArray.length) {
//                if (expectedArray.get(i) !== actualArray.get(i)) {
//                    arraysAreEqual = false
//                    break
//                }
//            }
//        }
//
//        assertFalse(arraysAreEqual) // La aserción fallará si las matrices son iguales en contenido
//

    }

    @Test
    fun getNameTest() {
        val assertions = Assertions()
        val name = "JUAN"
        assertNotEquals(name, assertions.getName())
    }

    @Test
    fun checkHumanTest() {
        val assertions = Assertions()
        val usu = User("JAIR", 2, true)
        val perro = User("CANDY", 2, false)
        assertEquals(usu.isHuman, assertions.checkHuman(usu))
        assertTrue(assertions.checkHuman(usu))
        assertFalse(assertions.checkHuman(perro))
    }

    @Test
    fun testUserNull() {
        val assertions = Assertions()
        val user = null
        val usuario = User()
        assertNull(user)
        assertNull(assertions.checkHuman(user))
        assertNotNull(usuario)
    }

    @Test
    fun testUserNotNull() {
        val usuario = User()
        assertNotNull(usuario)
    }

    @Test
    fun checkNotSameUserTest() {
        val usuario = User("jair", 1, true)
        val usuario3 = User("JAIR", 10, true)
        assertNotSame(usuario, usuario3)
    }

    @Test
    fun checkSameUserTest() {
        val usuario = User("jair", 1, true)
//        val usuario3 = User("jair", 10, true) TODO No funciona el asserSame() por la intancia
        val usuario3 = usuario
        assertSame(usuario, usuario3)
    }

    @Test(timeout = 1_000)
    fun checkTimeTest() {
        var usuario = User()
        val usuario3 = usuario
        Thread.sleep(950)
//        Thread.sleep(1950)
        assertSame(usuario, usuario3)
    }

//Recyclar codigo en TEST donde reutiliza
}