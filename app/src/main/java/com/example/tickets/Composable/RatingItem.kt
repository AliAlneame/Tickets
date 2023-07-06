package com.example.tickets.Composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.tickets.ui.theme.GGrey


@Composable
fun RatingItem(title: String, rating: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        MultiStyleText(rating, Color.Black, "/10", Color.Gray)
        Text(text = title, color = Color.Gray)
    }
}

@Composable
fun Tags(items: List<String>,modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        items(items) {
            Chip(text = it)
        }
    }
}
@Composable
fun Chip(text: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, GGrey),
        modifier = Modifier.padding(4.dp)
    ) {

        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .background(Color.White)
                .padding(horizontal = 13.dp, vertical = 6.dp)
        )

    }
}
