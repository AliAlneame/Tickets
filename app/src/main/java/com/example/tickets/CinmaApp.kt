package com.example.tickets

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tickets.Screens.Booking.BookingScreen
import com.example.tickets.Screens.ListofMovies.HomeScreen
import com.example.tickets.Screens.MovieDetails.MovieDetailsScreen

@Composable
fun CinmaApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

        composable(Screen.HomeScreen.route) { HomeScreen(navController) }
        composable(Screen.MovieDetailsScreen.route) { MovieDetailsScreen(navController) }
        composable(Screen.BookingScreen.route) { BookingScreen(navController) }


    }
}