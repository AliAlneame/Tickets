package com.example.tickets.repository

import com.example.tickets.Screens.ListofMovies.Movie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val dataSource: FakeDataSource) :
    MoviesRepository {

    override fun getMovies(): List<Movie> {
        return dataSource.getMovies()
    }

    override fun getNowShowingMovies(): List<Movie> {
        return dataSource.getNowShowingMovies()
    }

    override fun getComingSoonMovies(): List<Movie> {
        return dataSource.getComingSoonMovies()
    }
}
