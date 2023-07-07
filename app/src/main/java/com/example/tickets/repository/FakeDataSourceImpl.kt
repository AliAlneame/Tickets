package com.example.tickets.repository

import com.example.tickets.Screens.ListofMovies.Movie
import javax.inject.Inject

class FakeDataSourceImpl @Inject constructor() : FakeDataSource {

    override fun getNowShowingMovies () = listOf(
        Movie(
            1,
            "https://m.media-amazon.com/images/M/MV5BMTgzOTY3MTM0OV5BMl5BanBnXkFtZTcwNjc5MTI5MQ@@._V1_FMjpg_UX1000_.jpg",
            "Body of Lies",
            listOf("Action", "Thriller "),
            "2h 8m",
        ),
        Movie(
            2,
            "https://m.media-amazon.com/images/M/MV5BMjA1MDIzOTYwMV5BMl5BanBnXkFtZTcwMTM5OTA1MQ@@._V1_FMjpg_UX1000_.jpg",
            "The Kingdom",
            listOf("Action", "Thriller "),
            "1h 49m",
        ),
        Movie(
            3,
            "https://m.media-amazon.com/images/M/MV5BZjhkMDM4MWItZTVjOC00ZDRhLThmYTAtM2I5NzBmNmNlMzI1XkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1_FMjpg_UX1000_.jpg",
            "Saving Private Ryan",
            listOf("War", "Drama"),
            "2h 49m",
        ),
        Movie(
            4,
            "https://user-images.githubusercontent.com/90576202/250568264-101026cf-20f9-4f13-8235-b7674664ddc5.png",
            "Fantastic Beasts:The Secrets Of Dumbledore",
            listOf("Fantasy", "Adventure"),
            "2h 33m",
        ),
        Movie(
            5,
            "https://m.media-amazon.com/images/I/91zhWpXHVzL._AC_UF894,1000_QL80_.jpg",
            "13 Hours: The Secret Soldiers of Benghazi",
            listOf("War", "Action"),
            "2h 24m",
        ),
        Movie(
            6,
            "https://flxt.tmsimg.com/assets/p12981153_b_v8_aa.jpg",
            "Death Note",
            listOf(" Mystery,", "Psychological thriller", "Thriller"),
            "45 m",
        ),
    )

    override fun getComingSoonMovies () = listOf(
        Movie(
            7,
            "https://i.ytimg.com/vi/Y2Qr1a1AJqY/maxresdefault.jpg",
            "The Expendables 4",
            listOf("Action", "Adventure"),
            "3h 11m",
        ),
        Movie(
            8,
            "https://media0021.elcinema.com/uploads/_315x420_c7689308757442fdf7c659770108fdbad1b8470571732a384be8aa208af61223.jpg",
            "The Equalizer 3",
            listOf("Crime", "Action", "Vigilante"),
            "1h 93m",
        ),
        Movie(
            9,
            "https://movies.universalpictures.com/media/04-opp-dm-mobile-banner-1080x745-pl-f01-050523-1-1-1-6458870c70c1d-1.jpg",
            "Oppenheimer",
            listOf("War", "Drama "),
            "2h 33m",
        ),
    )
    override fun getMovies(): List<Movie> {
        return getNowShowingMovies().plus(getComingSoonMovies())
    }
}
