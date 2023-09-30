package com.example.aplicationtesting.calculator

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CalculadorActivityTest {
    @Mock
    private lateinit var operations: Operations

    @Mock
    private lateinit var listener: OnResolveListener

    lateinit var calculadorUtils: CalculatorUtils

    @Before
    fun setup() {
        calculadorUtils = CalculatorUtils(operations, listener)
    }

    @Test
    fun cacl_callCheckOrResolve_noReturn() {
        val operation = "-5x2.5"
        val isFromResolve = true
        //TODO indicamos que cuando nuestra clase calculator utils ejecute el metodo checkOrResolve
        calculadorUtils.checkOrResolve(operation, isFromResolve)

        //TODO verificamos que ejecutandose el metodo de arriba ,entonces verificamos que se hizo el metodo tryresolve
        verify(operations).tryResolve(operation, isFromResolve, listener)
        verify(operations).print()
    }

    @Test
    fun cacl_callAddOperator_validSub_noReturn() {
        val operator = "-"
        val operation = "4+"//4+-3
        var isCorrect = false
        calculadorUtils.addOperator(operator, operation) {
            isCorrect = true
        }
        assertTrue(isCorrect)
    }


    @Test
    fun calc_callAddOperator_invalidSub_noReturn() {
        //TODO SE CUMPLE DEBIDO A QUE NUNCA ESTAMOS ENTRANDO EN EL CALLBACK
        val operator = "-"
        val operation = "4+." //4+-3
        var isCorrect = false
        calculadorUtils.addOperator(operator, operation) {
            isCorrect = true
        }
        assertFalse(isCorrect)
    }


    @Test
    fun calc_callAddPoint_firtsPoint_noReturn() {
        val operation = "4x2"
        var isCorrect = false
        calculadorUtils.addPoint(operation) {
            isCorrect = true
        }
        assertTrue(isCorrect)
//        TODO VERIFICAMOS QUE NO INTERATUE CON operations
        verifyNoInteractions(operations)
    }


    @Test
    fun calc_callAddPoint_firstPoint_noReturns() {
        val operation = "3x2"
        var isCorrect = false
        calculadorUtils.addPoint(operation) {
            isCorrect = true
        }
        assertTrue(isCorrect)
        verifyNoInteractions(operations)
    }

    @Test
    fun calc_callAddPoint_secondPoint_noReturns() {
        val operation = "3.5x2"
        val operator = "x"
        var isCorrect = false
        /*
            TODO como operations es un mock a la hora de acceder a sus funciones que retornan valores
              nos retornara un valor como NULL
                Por lo tanto con el thenReturn simularemos los metodos de retorno de esa funcion
                */
        `when`(operations.getOperator(operation)).thenReturn("x")
        `when`(operations.divideOperation(operator, operation)).thenReturn(arrayOf("3.5", "2"))

        calculadorUtils.addPoint(operation) {
            isCorrect = true
        }
        assertTrue(isCorrect)
        verify(operations).getOperator(operation)
        verify(operations).divideOperation(operator, operation)
    }

}