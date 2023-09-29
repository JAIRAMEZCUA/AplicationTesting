package com.example.aplicationtesting.junit

import com.example.aplicationtesting.junit.Assertions
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/****
 * Project: Fundamentos JUnit
 * From: com.cursosant.fundamentosjunit
 * Created by Alain Nicolás Tello on 14/12/21 at 9:54
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/

//TODO SUSTITUYE A LO QUE ES LA HERENCIA , PERMITE SER REUTILIZABLE EN LOS TEST
class LocationESRule : TestRule {
    var assertions: Assertions? = null

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
//                todo Forzaremos que las Assertions sean con location (ES)
                assertions = Assertions()
                assertions?.setLocation("ES")
                try {
                    base?.evaluate()
                } finally {
                    assertions = null
                }
            }
        }
    }
}