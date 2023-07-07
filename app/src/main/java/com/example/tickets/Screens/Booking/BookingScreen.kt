package com.example.tickets.Screens.Booking

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tickets.Composable.BuyTicketsButton
import com.example.tickets.Composable.CardDateItem
import com.example.tickets.Composable.CardTimeItem
import com.example.tickets.Composable.ColumnSeats

import com.example.tickets.Composable.ExitButton
import com.example.tickets.Composable.RowIconText
import com.example.tickets.R
import com.example.tickets.Screen
import com.example.tickets.ui.theme.GGrey
import com.example.tickets.ui.theme.MGrey
import com.example.tickets.ui.theme.Orange

@Composable
fun BookingScreen(
    navController: NavController,
    viewModel: BookingViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    BookingContent(state, onClickExit = {navController.popBackStack(Screen.HomeScreen.route,false)})
}
@Composable
fun BookingContent(state: BookingUIState,onClickExit: () -> Unit)  {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black)
    ) {
        Cinema(modifier = Modifier.weight(2f), onClickExit = onClickExit)
        BottomSheet(state, Modifier.weight(0.8f))
    }
}
@Composable
private fun Cinema(modifier: Modifier = Modifier,onClickExit: () -> Unit)  {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = R.drawable.movie_image),
                contentDescription = "Cinema",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 58.dp)
                    .fillMaxHeight(.1f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .padding(top = 16.dp, end = 20.dp, start = 20.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                ColumnSeats(rowsNum = 5, rotation = 10f,modifier = Modifier.weight(1f))
                ColumnSeats(rowsNum = 5, modifier = Modifier.weight(1f))
                ColumnSeats(rowsNum = 5, rotation = -10f,Modifier.weight(1f))
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                RowIconText(text = "Available", iconColor = White)
                RowIconText(text = "Taken", iconColor = MGrey)
                RowIconText(text = "Selected", iconColor = Orange)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 46.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            ExitButton(onClickExit = onClickExit)
        }
    }
}
@Composable
private fun BottomSheet(state: BookingUIState, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp))
            .background(White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(end = 24.dp, start = 24.dp, top = 24.dp)
        ) {
            items(state.bookingDateItems) {
                CardDateItem(date = it.date, day = it.day, onClick = {})
            }
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(horizontal = 24.dp)
        ) {
            items(state.timeItems) {
                CardTimeItem(time = it, onClick = {})
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "$ ${state.price}", fontSize = 24.sp)
                Text(text = "${state.availableTickets} tickets", color = GGrey)
            }

            BuyTicketsButton(text = "Buy tickets")
        }


    }
}


