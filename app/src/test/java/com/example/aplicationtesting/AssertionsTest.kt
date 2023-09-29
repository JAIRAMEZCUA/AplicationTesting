package com.example.aplicationtesting

import org.junit.Assert.*
import org.junit.Test

class AssertionsTest {
    @Test
    fun getArrayTest() {
        val assertions = Assertions()
        val array = arrayOf(21, 117)
        val arrayFail = arrayOf(21, 11)

        assertArrayEquals(array, assertions.getLuckyNumbers())
        assertArrayEquals("Error en  arreglo", arrayFail, assertions.getLuckyNumbers())

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