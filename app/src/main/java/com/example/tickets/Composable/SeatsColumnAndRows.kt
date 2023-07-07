package com.example.tickets.Composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tickets.R
import com.example.tickets.ui.theme.GGrey
import com.example.tickets.ui.theme.MGrey

@Composable
fun ColumnSeats(rowsNum: Int, rotation: Float = 0f, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        for (i in 1..rowsNum) {
            RowSeat(rotation, modifier = Modifier.weight(1f))
        }

    }
}

@Composable
fun RowSeat(rotation: Float = 0f, modifier: Modifier = Modifier) {
    val paddingValue = if (rotation == 0f) {
        PaddingValues(12.dp)
    } else {
        PaddingValues(top = 12.dp, start = 12.dp, end = 12.dp, bottom = 32.dp)
    }

    Row(
        modifier = modifier
            .fillMaxSize()
            .rotate(rotation)
            .padding(paddingValue)
    ) {
        IconSeat(modifier = Modifier.weight(1f))
        IconSeat(modifier = Modifier.weight(1f))
    }

}

@Composable
fun IconSeat(modifier: Modifier = Modifier) {

    val seatColor = remember { mutableStateOf(GGrey) }

    val clickCount = remember { mutableStateOf(0) }

    Icon(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                clickCount.value = (clickCount.value + 1) % 3
                seatColor.value = when (clickCount.value) {
                    0 -> GGrey
                    1 -> Color.White
                    2 -> Color.Red
                    else -> GGrey
                }
            },
        painter = painterResource(id = R.drawable.seat),
        contentDescription = "seat",
        tint = seatColor.value,
    )
}

@Composable
fun RowIconText(
    text: String,
    iconColor: Color,
    modifier: Modifier = Modifier
) {
    Row(

    ) {
        Icon(
            painter = painterResource(id = R.drawable.dark_cir),
            contentDescription = "Dot",
            modifier = modifier.size(20.dp),
            tint = iconColor
        )
        Text(text = text, color = MGrey)
    }
}