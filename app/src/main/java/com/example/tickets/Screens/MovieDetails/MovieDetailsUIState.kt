package com.example.tickets.Screens.MovieDetails

data class MovieDetailsUIState(
    val movieImage: String = " ",
    val movieDuration : String = "",
    val movieName : String = "",
    val movieDescription : String = "",
    val movieActor : List<String> = emptyList(),
    val tags: List<String> = emptyList(),
    val rating :  List<String> = emptyList(),
)