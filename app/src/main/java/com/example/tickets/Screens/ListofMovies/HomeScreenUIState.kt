package com.example.tickets.Screens.ListofMovies

data class HomeUIState(
    val movies: List<com.example.tickets.Screens.ListofMovies.Movie> = emptyList(),
    val homeContentType: HomeContentType = HomeContentType.NowShowing,
    )
