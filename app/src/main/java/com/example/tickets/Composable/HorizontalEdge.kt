package com.example.tickets.Composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
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
import com.example.tickets.Screens.ListofMovies.Movie

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalEdge(
    pagerState: PagerState,
    onClick: () -> Unit,
    items: List<Movie>,
    modifier: Modifier = Modifier,
    onItemSelected: (Movie) -> Unit,

    ) {
    HorizontalPager(
        state = pagerState,
        pageCount = items.size,
        contentPadding = PaddingValues(horizontal = 64.dp),
        modifier = modifier
    ) { page ->

        val movie = items[page % items.size]

        if (pagerState.currentPage in items.indices) {
            onItemSelected(items[pagerState.currentPage])
        }
        val animatedScale by animateFloatAsState(
            targetValue = if (page == pagerState.currentPage) 1f else 0.7f,
            animationSpec = tween(durationMillis = 200)
        )
        Image(
            painter = rememberAsyncImagePainter(model = movie.imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(300.dp)
                .height(400.dp)
                .aspectRatio(3 / 4f)
                .scale(animatedScale)
                .clip(MaterialTheme.shapes.extraLarge)
                .clickable {onClick() }
        )
    }
}