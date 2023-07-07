package com.example.tickets.Screens.ListofMovies


import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tickets.BottomNav
import com.example.tickets.Composable.ButtonHomeContent
import com.example.tickets.Composable.HorizontalEdge
import com.example.tickets.Composable.ImageBackground
import com.example.tickets.Composable.RowIconText
import com.example.tickets.Composable.RowTagsChips
import com.example.tickets.Composable.TextCentered
import com.example.tickets.R
import com.example.tickets.Screen
import com.example.tickets.ui.theme.GGrey


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    HomeContent(
        state,
        viewModel,
        onClick = { navController.navigate(Screen.MovieDetailsScreen.route) })
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeContent(state: HomeUIState, viewModel: HomeScreenInteractions, onClick: () -> Unit) {
    val pagerState = rememberPagerState(initialPage = state.movies.size / 2)
    var selectedMovie by remember { mutableStateOf(state.movies[state.movies.size / 2]) }
    Scaffold(bottomBar = { BottomNav() }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box {
                ImageBackground(selectedMovie.imageUrl)
                HorizontalEdge(
                    modifier = Modifier
                        .padding(top = 120.dp)
                        .fillMaxWidth(),
                    pagerState = pagerState,
                    onClick = onClick,
                    items = state.movies
                ) { movie ->
                    selectedMovie = movie
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp)
                ) {
                    ButtonHomeContent(
                        buttonText = "Now Showing",
                        selected = state.homeContentType == HomeContentType.NowShowing,
                        onClick = { viewModel.updateHomeContent(HomeContentType.NowShowing) }
                    )
                    ButtonHomeContent(
                        buttonText = "Coming Soon",
                        selected = state.homeContentType == HomeContentType.ComingSoon,
                        onClick = { viewModel.updateHomeContent(HomeContentType.ComingSoon) }
                    )
                }
            }
            RowIconText(
                text = selectedMovie.duration,
                iconColor = GGrey,
                textColor = Black,
                painter = painterResource(id = R.drawable.baseline_access_time_24),
                modifier = Modifier.padding(top = 20.dp)
            )
            TextCentered(text = selectedMovie.title, size = 26.sp)
            RowTagsChips(items = selectedMovie.tags, modifier = Modifier.padding(top = 16.dp))

        }

    }


}