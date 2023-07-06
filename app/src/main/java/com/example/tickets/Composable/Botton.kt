package com.example.tickets.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tickets.ui.theme.Orange
import com.example.tickets.ui.theme.SGray



@Composable
fun ChipButton(text: String, Seleclected: Boolean) {
    if (Seleclected) {
        ChipBox(
            text = text,
            modifier = Modifier
                .background(
                    color = Orange,
                    shape = RoundedCornerShape(size = 24.dp)
                )
        )
    }else{
        ChipBox(
            text = text,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = SGray,
                    shape = RoundedCornerShape(size = 24.dp)
                )
        )
    }
}

@Composable
fun ChipBox(text: String, modifier: Modifier) = Box(
    modifier = Modifier
        .padding(horizontal = 12.dp, vertical = 8.dp),
    contentAlignment = Alignment.Center
) {
    Text(
        text = text,
        fontSize = 16.sp,
        color = Color(0xDEFFFFFF)
    )
}