package com.example.aplicationtesting.auth

/****
 * Project: Auth
 * From: com.cursosandroidant.auth
 * Created by Alain Nicolás Tello on 14/12/21 at 14:01
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
enum class AuthEvent {
    //success
    USER_EXIST,

    //fail
    LENGTH_PASSWORD,
    NOT_USER_EXIST,
    EMPTY_EMAIL,
    EMPTY_PASSWORD,
    EMPTY_FORM,
    INVALID_EMAIL,
    INVALID_PASSWORD,
    INVALID_USER,

    //Exceptions
    NULL_EMAIL,
    NULL_PASSWORD,
    NULL_FORM
}