package com.example.tickets

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.tickets.MovieDetailsArgs.Companion.ID_ARG
import com.example.tickets.Screens.MovieDetails.MovieDetailsScreen

fun NavController.navigateTOMovieDetails(id: Int) {
    navigate("$ROUTE/${id.toString()}")
}
private const val ROUTE = "MovieDetailsScreen"
fun NavGraphBuilder.DetailsScreen(navController: NavController) {
    composable(
        route = "$ROUTE/{$ID_ARG}",

        arguments = listOf(
            navArgument(ID_ARG) { NavType.StringType },

        )
    ) { MovieDetailsScreen(navController) }
}

class MovieDetailsArgs(savedStateHandle: SavedStateHandle) {
    val id: String = savedStateHandle[ID_ARG] ?: "0"


    companion object {
        const val ID_ARG = "id"

    }
}
