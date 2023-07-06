package com.example.tickets.Screens.MovieDetails

import com.example.tickets.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor() :
    BaseViewModel<MovieDetailsUIState>(MovieDetailsUIState()) {
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
                tags = tags,
                movieDuration ="2h 23m",
                movieName = "Fantastic Beasts:The Secrets Of Dumbledore",
                movieDescription = "Professor Albus Dumbledore must assist Newt Scamander and his partners as Grindelwald begins to lead an army to eliminate all Muggles.",
                movieImage = "https://images.ctfassets.net/usf1vwtuqyxm/77BW3OW4tz6AGODWQLjWev/f7a462471c8c2895854a0f57d5d5a906/fb3-posters-niffler.jpg?w=914&q=70&fm=webp"
            )
        }
    }


}