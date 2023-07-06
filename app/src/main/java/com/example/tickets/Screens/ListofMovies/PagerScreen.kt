package com.example.tickets.Screens.ListofMovies

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

data class MovieList(val imageURLs: List<String>)
    val movieList = MovieList(
        imageURLs = listOf(
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://i1.sndcdn.com/artworks-000062148376-aaasja-t500x500.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://i1.sndcdn.com/artworks-000062148376-aaasja-t500x500.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://i1.sndcdn.com/artworks-000062148376-aaasja-t500x500.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://i1.sndcdn.com/artworks-000062148376-aaasja-t500x500.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://i1.sndcdn.com/artworks-000062148376-aaasja-t500x500.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://i1.sndcdn.com/artworks-000062148376-aaasja-t500x500.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://i1.sndcdn.com/artworks-000062148376-aaasja-t500x500.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://i1.sndcdn.com/artworks-000062148376-aaasja-t500x500.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
        )
    )
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviePager(
    pagerState: PagerState,
    onItemSelected: (String) -> Unit,
) {
    HorizontalPager(
        state = pagerState,
        pageCount = movieList.imageURLs.size,
        contentPadding = PaddingValues(horizontal = 64.dp),
        modifier = Modifier.fillMaxWidth()
    ) { page ->
        val imageUrl = movieList.imageURLs[page % movieList.imageURLs.size]

        onItemSelected(movieList.imageURLs[pagerState.currentPage])

        val animatedScale by animateFloatAsState(
            targetValue = if (page == pagerState.currentPage) 1f else 0.8f,
            animationSpec = tween(durationMillis = 200)
        )

        Image(painter = rememberAsyncImagePainter(model = imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(300.dp)
                .height(400.dp)
                .aspectRatio(3 / 4f)
                .scale(animatedScale)
                .clip(MaterialTheme.shapes.extraLarge)
                .clickable { })
    }

}