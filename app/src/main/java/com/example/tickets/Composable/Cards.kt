package com.example.tickets.Composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.tickets.ui.theme.GGrey

@Composable
fun CardDateItem(date: String, day: String, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(1.dp, GGrey),
        modifier = Modifier
            .clickable(onClick = onClick)
            .height(64.dp)
            .width(54.dp)
    ) {
        ColumnFillInCard {
            TextCenteredInCard(date)
            TextCenteredInCard(day)
        }
    }
}

@Composable
fun ColumnFillInCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        content = content
    )
}

@Composable
fun TextCenteredInCard(value: String, modifier: Modifier = Modifier) {
    Text(text = value, textAlign = TextAlign.Center, modifier = modifier.fillMaxWidth())
}

@Composable
fun CardTimeItem(time: String, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, GGrey),
        modifier = Modifier
            .clickable(onClick = onClick)
            .height(38.dp)
            .width(56.dp),
    ) {
        ColumnFillInCard {
            TextCenteredInCard(time)
        }
    }
}
