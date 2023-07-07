package com.example.tickets.Screens.ListofMovies

data class Movie(
    val imageUrl: String,
    val title: String,
    val tags: List<String>,
    val duration: String
)
