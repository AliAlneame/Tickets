package com.example.tickets.Screens.ListofMovies

import com.example.tickets.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeUIState>(HomeUIState()),
    HomeScreenInteractions {
    override fun updateHomeContent(selectedContent: HomeContentType) {
        _state.update {
            it.copy(
                homeContentType = selectedContent, movies = when (selectedContent) {
                    HomeContentType.ComingSoon -> comingSoonItems
                    HomeContentType.NowShowing -> nowShowingItems
                }
            )
        }
    }
    private val nowShowingItems = listOf(

        Movie(
            "https://m.media-amazon.com/images/M/MV5BMTgzOTY3MTM0OV5BMl5BanBnXkFtZTcwNjc5MTI5MQ@@._V1_FMjpg_UX1000_.jpg",
            "Body of Lies",
            listOf("Action", "Thriller "),
            "2h 8m",
        ),
        Movie(
            "https://m.media-amazon.com/images/M/MV5BMjA1MDIzOTYwMV5BMl5BanBnXkFtZTcwMTM5OTA1MQ@@._V1_FMjpg_UX1000_.jpg",
            "The Kingdom",
            listOf("Action", "Thriller "),
            "1h 49m",
        ),
        Movie(
            "https://m.media-amazon.com/images/M/MV5BZjhkMDM4MWItZTVjOC00ZDRhLThmYTAtM2I5NzBmNmNlMzI1XkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_FMjpg_UX1000_.jpg",
            "Saving Private Ryan",
            listOf("War", "Drama"),
            "2h 49m",
        ),
        Movie(
            "https://user-images.githubusercontent.com/90576202/250568264-101026cf-20f9-4f13-8235-b7674664ddc5.png",
            "Fantastic Beasts:The Secrets Of Dumbledore",
            listOf("Fantasy", "Adventure"),
            "2h 33m",
        ),
        Movie(
            "https://m.media-amazon.com/images/I/91zhWpXHVzL._AC_UF894,1000_QL80_.jpg",
            "13 Hours: The Secret Soldiers of Benghazi",
            listOf("War", "Action"),
            "2h 24m",
        ),
        Movie(
            "https://flxt.tmsimg.com/assets/p12981153_b_v8_aa.jpg",
            "Death Note",
            listOf(" Mystery,", "Psychological thriller", "Thriller"),
            "45 m",
        ),
    )

    private val comingSoonItems = listOf(
        Movie(
            "https://i.ytimg.com/vi/Y2Qr1a1AJqY/maxresdefault.jpg",
            "The Expendables 4",
            listOf("Action", "Adventure"),
            "3h 11m",
        ),
        Movie(
            "https://media0021.elcinema.com/uploads/_315x420_c7689308757442fdf7c659770108fdbad1b8470571732a384be8aa208af61223.jpg",
            "The Equalizer 3",
            listOf("Crime", "Action", "Vigilante"),
            "1h 93m",
        ),
        Movie(
            "https://movies.universalpictures.com/media/04-opp-dm-mobile-banner-1080x745-pl-f01-050523-1-1-1-6458870c70c1d-1.jpg",
            "Oppenheimer",
            listOf("War", "Drama "),
            "2h 33m",
        ),
    )

    init {
        _state.update {
            it.copy(
                nowShowingItems
            )
        }
    }
}