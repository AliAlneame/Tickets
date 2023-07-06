package com.example.tickets

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import coil.compose.rememberAsyncImagePainter
import com.example.tickets.Composable.App
import com.example.tickets.Composable.Background
import com.example.tickets.Composable.MultiStyleText
import com.example.tickets.Composable.NavScreen
import com.example.tickets.Composable.UpperScreen
import com.example.tickets.ui.theme.Orange
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            NavScreen ()
        }



    }
}



//            WindowCompat.setDecorFitsSystemWindows(window, false)
//            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
//            val systemUiController = rememberSystemUiController()
//            systemUiController.setStatusBarColor(
//                color = Color.Transparent, darkIcons = false
//            )
//        @Composable
//        fun App() {
//            val pagerState = rememberPagerState(initialPage = movieList.imageURLs.size / 2)
//            var selectedImageUrl by remember { mutableStateOf(movieList.imageURLs[movieList.imageURLs.size / 2]) }
//
//            Box(modifier = Modifier.fillMaxSize()) {
//
//                Background(selectedImageUrl)
//
//                Column(modifier = Modifier.fillMaxWidth()) {
//                    Spacer(modifier = Modifier.height(200.dp))
//
//                    MoviePager(pagerState = pagerState) { imageUrl ->
//                        selectedImageUrl = imageUrl
//                    }
//                }
//            }
//        }




@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun MyApp() {
    val imageResId = R.drawable.screenshot_2
    val movieList = MovieList(
        imageURLs = listOf(
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
        )
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        UpperScreen(imageResId)
        MovieRow(Modifier,movieList.imageURLs)
        MovieDetails(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .height(455.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp))
                .background(color = Color.White)
        )


    }

}

@Composable
fun RatingItem(title: String, rating: String, subtitle: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        MultiStyleText(rating, Color.Black, "/10", Color.Gray)
        Text(text = title, color = Color.Gray)
    }
}

@Composable
fun GenreItem(genre: String) {
    Surface(
        shape = RoundedCornerShape(32.dp),
        color = Color.Transparent,
        border = BorderStroke(width = 1.dp, color = Color(0xFFebebeb)),
        modifier = Modifier
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = genre,
            modifier = Modifier.padding(6.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MovieDetails(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp))
            .background(color = Color.White)
    )
    Column(
        modifier = modifier
            .height(480.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp))

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            RatingItem("IMDB", "6.8", "/10")
            RatingItem("Rotten Tomatoes", "63%", "")
            RatingItem("IGN", "4", "/10")
        }
        Text(
            text = "Fantastic Beasts: The Secrets of Dumbledore",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(horizontal = 40.dp),
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            GenreItem("Fantasy")
            GenreItem("Adventure")
        }
        MovieList(
            imageURLs = listOf(
                "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
                "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
                "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
                "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
                "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
                "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
                "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
                "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
                "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
                "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
                "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
                "https://media.filfan.com/NewsPics/FilfanNew/large/2008.jpg",
            )
        )
        Text(
            text = "Professor Albus Dumbledore must assist Newt Scamander and his partners as Grindelwald begins to lead an army to eliminate all Muggles.",
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .padding(horizontal = 16.dp),
            textAlign = TextAlign.Start
        )

        Spacer(
            modifier = Modifier
                .height(12.dp)
        )

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)


        ) {
            Icon(
                painter = painterResource(id = R.drawable.outline_credit_card_24),
                contentDescription = null,
                tint = Color(0xFFf5ede4),
                modifier = Modifier
                    .size(28.dp)
                    .padding(horizontal = 4.dp)
            )
            Text(text = "Booking")
        }
    }
}

@Composable
fun MovieRow(modifier: Modifier = Modifier, imageURLs: List<String>) {
    LazyRow(
        modifier = modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(imageURLs) { imageURL ->
            Image(
                painter = rememberAsyncImagePainter(model = imageURL),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
        }
    }
}
