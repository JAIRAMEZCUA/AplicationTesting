package com.example.aplicationtesting.hamcrest

import com.example.aplicationtesting.auth.AuthEvent
import com.example.aplicationtesting.auth.AuthException
import com.example.aplicationtesting.auth.userAuthenticationTDD
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.both
import org.hamcrest.Matchers.containsString
import org.hamcrest.Matchers.endsWith
import org.hamcrest.Matchers.everyItem
import org.hamcrest.Matchers.hasItemInArray
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not
import org.junit.Assert
import org.junit.Test

/****
 * Project: Auth
 * From: com.cursosandroidant.auth
 * Created by Alain Nicolás Tello on 15/12/21 at 11:19
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class AuthHamcrestTest {

    /*TODO
        HAMCREST funciona con base a matchers nos ayuda a escribir comparaciones
       de objetos o valores de una forma muy descriptiva*/

    //given-when-then
    /*TODO
       GIVEN --> DADO QUE  : tengamos un login del usuario ,
       WHEN -> con informacionCorrecta
       RETURN -> regresaremos un caso exitoso */
    @Test
    fun loginUser_correctData_returnsSuccessEvent() {
        val result = userAuthenticationTDD("ant@gmail.com", "1234")
        assertThat(AuthEvent.USER_EXIST, `is`(result))
    }

    @Test
    fun loginUser_wrongData_returnsFailEvent() {
        val result = userAuthenticationTDD("nt@gmail.com", "1234")
        assertThat(AuthEvent.NOT_USER_EXIST, `is`(result))
    }

    @Test
    fun loginUser_emptyEmail_returnsFailEvent() {
        val result = userAuthenticationTDD("", "1234")
        assertThat(AuthEvent.EMPTY_EMAIL, `is`(result))
    }

    @Test
    fun loginUser_emptyPassword_returnsFailEvent() {
        val result = userAuthenticationTDD("ant@gmail.com", "")
        assertThat(AuthEvent.EMPTY_PASSWORD, `is`(result))
    }

    @Test
    fun loginUser_emptyForm_returnsFailEvent() {
        val result = userAuthenticationTDD("", "")
        assertThat(AuthEvent.EMPTY_FORM, `is`(result))
    }

    @Test
    fun loginUser_invalidEmail_returnsFailEvent() {
        val result = userAuthenticationTDD("ant@gmailcom", "1234")
        assertThat(AuthEvent.INVALID_EMAIL, `is`(result))
    }

    @Test
    fun loginUser_invalidPassword_returnsFailEvent() {
        val result = userAuthenticationTDD("ant@gmail.com", "123e")
        assertThat(AuthEvent.INVALID_PASSWORD, `is`(result))
    }

    @Test
    fun loginUser_invalidUser_returnsFailEvent() {
        val result = userAuthenticationTDD("ant@gmailcom", "123e")
        assertThat(AuthEvent.INVALID_USER, `is`(result))
    }

    @Test(expected = AuthException::class)
    fun loginUser_nullEmail_returnsException() {
        val result = userAuthenticationTDD(null, "123e")
        assertThat(AuthEvent.NULL_EMAIL, `is`(result))
    }

    @Test
    fun loginUser_nullPassword_returnsException() {
        Assert.assertThrows(AuthException::class.java) {
            print(userAuthenticationTDD("ant@gmail.com", null))
        }
    }

    @Test
    fun loginUser_nullForm_returnsException() {
        try {
            val result = userAuthenticationTDD(null, null)
            assertThat(AuthEvent.NULL_FORM, `is`(result))
        } catch (e: Exception) {
            (e as? AuthException)?.let {
                assertThat(AuthEvent.NULL_FORM, `is`(it.authEvent))
            }
        }
    }

    @Test
    fun loginUser_errorLengthPassword_returnsFailEvent() {
        val result = userAuthenticationTDD("ant@gmailcom", "123")
        assertThat(AuthEvent.LENGTH_PASSWORD, `is`(result))
    }

    @Test
    fun checkNames_differentUsers_match() {
        assertThat("Maria", both(containsString("a")).and(containsString("i")))
    }

    @Test
    fun checkData_emailPassword_noMatch() {
        val email = "ant@gmail.com"
        val password = "1234"
        assertThat(email, not(`is`(password)))
    }

    @Test
    fun checkExist_newEmail_returnsString() {
        val oldEmail = "ant@gmail.com"
        val newEmail = "ant@cursosandroid.com"
        val emails = arrayOf(oldEmail, newEmail)
        assertThat(emails, hasItemInArray(newEmail))
    }

    @Test
    fun checkDomain_arrayEmails_returnsString() {
        val nextEmail = "alain@cursosandroid.com"
        val oldEmail = "ant@gmail.com"
        val newEmail = "ant@cursosandroid.com"
        val emails = arrayListOf(oldEmail, newEmail, nextEmail)
        val newEmails = arrayListOf(newEmail, nextEmail)
        assertThat(newEmails, everyItem(endsWith("cursosandroid.com")))
    }
}