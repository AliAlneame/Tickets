package com.example.tickets.Screens.ListofMovies

sealed class HomeContentType {
    object NowShowing : HomeContentType()
    object ComingSoon : HomeContentType()
}