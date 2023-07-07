package com.example.tickets.Composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun TextCentered(
    text: String,
    size : TextUnit,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        fontSize = (size),
        textAlign = TextAlign.Center,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier.padding(top = 16.dp, end = 46.dp, start = 46.dp)
    )
}