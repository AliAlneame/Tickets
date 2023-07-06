package com.example.tickets.Composable

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tickets.Screens.Booking.BookingScreen
import com.example.tickets.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavScreen (){

//    val navController = rememberNavController()
//
//    Scaffold(bottomBar = { BottomBar(navController = navController) }) {
//        BottomNavGraph(navController = navController)
//    }
}

//@Composable
//fun BottomBar(navController: NavHostController) {
//    val screens = listOf(
//        BottomNavScreen.Home,
//        BottomNavScreen.Search,
//        BottomNavScreen.Tickets,
//        BottomNavScreen.Profile,
//
//        )
//    val navStackBackEntry by navController.currentBackStackEntryAsState()
//    val currentDestination = navStackBackEntry?.destination
//    Row(
//        modifier = Modifier
//            .padding(vertical = 8.dp, horizontal = 20.dp)
//            .background(White)
//            .fillMaxWidth(),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        screens.forEach { screen ->
//            AddItem(
//                screen = screen,
//                currentDestination = currentDestination,
//                navController = navController
//            )
//        }
//    }
//
//}

@Composable
fun RowScope.AddItem(
    screen: BottomNavScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    val background = if (selected) Orange.copy(alpha = 0.6f) else Color.Transparent
    val contentColor = if (selected) Color.White else Color.Black
    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            })
    ) {
        Icon(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 10.dp),
            painter = painterResource(id = screen.icon),
            contentDescription = "icon",
            tint = contentColor
        )
    }
}

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavScreen.Home.route){
        composable(route = BottomNavScreen.Home.route){

        }
        composable(route = BottomNavScreen.Tickets.route){
            BookingScreen()
        }
    }
}