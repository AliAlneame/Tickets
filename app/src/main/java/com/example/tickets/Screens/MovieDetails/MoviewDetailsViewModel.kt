package com.example.tickets.Screens.MovieDetails

import androidx.lifecycle.SavedStateHandle
import com.example.tickets.BaseViewModel
import com.example.tickets.MovieDetailsArgs
import com.example.tickets.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle,repository: MoviesRepository) :
    BaseViewModel<MovieDetailsUIState>(MovieDetailsUIState()) {
    val args = MovieDetailsArgs(savedStateHandle).id
    val movie = repository.getNowShowingMovies().get(args.toInt())
    private val ActorImage = listOf(
        "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
        "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
        "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
        "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
        "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
        "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
        "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
        "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
        "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
        "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
        "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
        "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
    )

    private val tags = listOf("Fantasy", "Adventure")
    private val rating = listOf(
        "6.8",
        "63%",
        "4",
    )
    init {
        _state.update {
            it.copy(
                movieActor = ActorImage,
                rating = rating,
                tags = movie.tags,
                movieDuration =movie.duration,
                movieName = movie.title,
                movieDescription = "Professor Albus Dumbledore must assist Newt Scamander and his partners as Grindelwald begins to lead an army to eliminate all Muggles.",
                movieImage =  movie.imageUrl
            )
        }
    }
}