package com.example.tickets

sealed class Screen(val route: String){
    object HomeScreen : Screen("HomeScreen")
    object MovieDetailsScreen : Screen("MovieDetailsScreen")
    object BookingScreen : Screen("BookingScreen")
}