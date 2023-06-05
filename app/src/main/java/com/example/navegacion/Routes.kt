package com.example.navegacion

sealed class Routes(val route:String) {
    object Pantalla1:Routes("screen1")
    object Pantalla2:Routes("screen2")
    object Pantalla3:Routes("screen3")
}