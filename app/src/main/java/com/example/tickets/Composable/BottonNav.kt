package com.example.tickets.Composable

import com.example.tickets.R


sealed class BottomNavScreen(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomNavScreen(
        route = "homeScreen",
        title = "Home",
        icon = R.drawable.home
    )
    object Search : BottomNavScreen(
        route = "search",
        title = "Search",
        icon = R.drawable.search
    )
    object Tickets : BottomNavScreen(
        route = "bookingScreen",
        title = "Tickets",
        icon = R.drawable.ticket
    )
    object Profile : BottomNavScreen(
        route = "profile",
        title = "Profile",
        icon = R.drawable.profile
    )

}