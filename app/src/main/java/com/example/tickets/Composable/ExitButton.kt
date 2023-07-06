package com.example.tickets.Composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tickets.R
import com.example.tickets.ui.theme.P
import com.example.tickets.ui.theme.SGray
@Preview
@Composable
fun ExitButton() {
    IconButton(
        onClick = { },
        modifier = Modifier
            .wrapContentWidth(Alignment.Start)
            .clip(CircleShape)
            .size(32.dp)
            .background(SGray)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_close_24),
            contentDescription = null,
            tint = Color(0xFFf5ede4),
            modifier = Modifier.size(12.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.outline_circle_24),
            contentDescription = null,
            tint = Color(0xFFf5ede4),
            modifier = Modifier.size(24.dp)
        )
    }
}
