package com.example.tickets.Screens.MovieDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.tickets.Composable.ExitButton
import com.example.tickets.R
import com.example.tickets.ui.theme.Orange
import com.example.tickets.ui.theme.SGray
import com.example.tickets.ui.theme.TSText

@Composable
fun UpperScreen(state: MovieDetailsUIState,onClickExit : () -> Unit) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = rememberAsyncImagePainter(model = state.movieImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(460.dp),
            contentScale = ContentScale.FillBounds
        )
        IconButton(
            onClick = {},
            modifier = Modifier
                .align(Alignment.Center)
                .clip(CircleShape)
                .size(46.dp)
                .background(Orange)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_play_arrow_24),
                contentDescription = null,
                tint = Color(0xFFf5ede4),
                modifier = Modifier
                    .size(28.dp)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 46.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ExitButton(onClickExit = onClickExit )
            Row(
                modifier = Modifier
                    .wrapContentWidth(Alignment.End)
                    .background(
                        SGray,
                        shape = RoundedCornerShape(32.dp)
                    )
                    .padding(horizontal = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_access_time_24),
                    contentDescription = null,
                    tint = Color(0xFF8f9899),
                    modifier = Modifier
                        .size(32.dp)
                        .padding(horizontal = 4.dp)
                )
                Text(
                    text = state.movieDuration,
                    color = TSText,
                    modifier = Modifier
                )
            }
        }
    }
}
