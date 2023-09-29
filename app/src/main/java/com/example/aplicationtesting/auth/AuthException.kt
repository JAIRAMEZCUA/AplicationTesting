package com.example.aplicationtesting.auth

/****
 * Project: Auth
 * From: com.cursosandroidant.auth
 * Created by Alain Nicolás Tello on 14/12/21 at 17:54
 * All rights reserved 2021.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class AuthException(val authEvent: AuthEvent, msg: String? = null) : Exception(msg)