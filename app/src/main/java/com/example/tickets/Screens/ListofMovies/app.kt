package com.example.tickets.Screens.ListofMovies

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tickets.Composable.Background


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieScreenPager() {
    val pagerState = rememberPagerState(initialPage = movieList.imageURLs.size / 2)
    var selectedImageUrl by remember { mutableStateOf(movieList.imageURLs[movieList.imageURLs.size / 2]) }

    Box(modifier = Modifier.fillMaxSize()) {

        Background(selectedImageUrl)

        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(130.dp))

            MoviePager(pagerState = pagerState) { imageUrl ->
                selectedImageUrl = imageUrl
            }
        }
    }
}