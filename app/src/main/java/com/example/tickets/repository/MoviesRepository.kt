package com.example.tickets.repository

import com.example.tickets.Screens.ListofMovies.Movie

interface MoviesRepository {
    fun getMovies():List<Movie>
    fun getNowShowingMovies(): List<Movie>
    fun getComingSoonMovies(): List<Movie>
}