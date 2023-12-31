package com.example.tickets.Screens.MovieDetails

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.tickets.Composable.MovieRow

import com.example.tickets.Composable.RatingItem
import com.example.tickets.Composable.Tags

import com.example.tickets.R
import com.example.tickets.Screen

import com.example.tickets.ui.theme.Orange
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieDetailsScreen(
    navController: NavController,
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    Content(state, onClickBookingButton = { navController.navigate(Screen.BookingScreen.route)}, onClickExit = { navController.popBackStack(Screen.HomeScreen.route,false)}
    )
}
@Composable
fun Content(state: MovieDetailsUIState, onClickBookingButton: () -> Unit, onClickExit: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        UpperScreen(state,onClickExit = onClickExit,)
        MovieDetails(
            state = state,
            onClickBookingButton = onClickBookingButton,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .fillMaxHeight(0.55f)
                .clip(shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp))
                .background(color = Color.White)
        )
    }
}
@Composable
fun MovieDetails(
    modifier: Modifier = Modifier,
    state: MovieDetailsUIState,
    onClickBookingButton: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp))
            .background(color = Color.White)
    )
    Column(
        modifier = modifier
            .height(480.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp))

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RatingItem("IMDB", state.rating[0])
            RatingItem("Rotten Tomatoes", state.rating[1])
            RatingItem("IGN", state.rating[2])
        }
        Text(
            text = state.movieName,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(horizontal = 40.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Tags(state.tags)
        }

        Text(
            text = state.movieDescription,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Start
        )

        Spacer(
            modifier = Modifier
                .height(12.dp)
        )

        MovieRow(imageURLs = state.movieActor)
        Spacer(
            modifier = Modifier
                .weight(1f)

        )
        Button(
            onClick = { onClickBookingButton() },
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_credit_card_24),
                contentDescription = null,
                tint = Color(0xFFf5ede4),
                modifier = Modifier
                    .size(28.dp)
                    .padding(horizontal = 4.dp)
            )
            Text(text = "Booking")
        }
    }
}

