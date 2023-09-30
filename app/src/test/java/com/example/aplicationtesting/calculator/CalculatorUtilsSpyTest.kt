package com.example.aplicationtesting.calculator

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CalculatorUtilsSpyTest {
    /*TODO EL SPY ES PARA DEJAR DE DEPENDER DEL PASO DE VARIABLES DE LA FUNCION Y ESTAS SEAN DINAMICAS
    *
    * PRINCIPALMENTE NOS AYUDARA A QUE LAS OPERACIONES DE RETORNO CON MOCK OPERATIONS DEJE DE SER NULO
    *
    * SPY AYUDA TANTO A propiedas y a atributos
    * */

    @Spy
    private lateinit var operations: Operations

    @Mock
    private lateinit var listener: OnResolveListener

    lateinit var calculadorUtils: CalculatorUtils

    @Before
    fun setup() {
        calculadorUtils = CalculatorUtils(operations, listener)
    }

    @Test
    fun calc_callAddPoint_validSecondPoint_noReturns() {
        val operation = "3.5x2"
        val operator = "x"
        var isCorrect = false
        calculadorUtils.addPoint(operation) {
            isCorrect = true
        }
        Assert.assertTrue(isCorrect)
        Mockito.verify(operations).getOperator(operation)
        Mockito.verify(operations).divideOperation(operator, operation)
    }

    @Test
    fun calc_callAddPoint_secondPoint_noReturns() {
        val operation = "3.5x2."
        val operator = "x"
        var isCorrect = false
        calculadorUtils.addPoint(operation) {
            isCorrect = true
        }
        Assert.assertFalse(isCorrect)
        Mockito.verify(operations).getOperator(operation)
        Mockito.verify(operations).divideOperation(operator, operation)
    }


}