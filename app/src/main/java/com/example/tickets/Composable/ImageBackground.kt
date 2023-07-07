package com.example.tickets.Composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.tickets.ui.theme.GGrey
import com.example.tickets.ui.theme.Orange

@Composable
fun ImageBackground(imageUrl: String) {
    Image(
        painter = rememberAsyncImagePainter(model = imageUrl),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .blur(radius = 50.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
            .fillMaxWidth()
            .fillMaxHeight(0.4f)
    )
}

@Composable
fun ButtonHomeContent(
    buttonText: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor by animateColorAsState(
        targetValue = if (selected) Orange else Color.Transparent
    )
    val borderColor by animateColorAsState(
        targetValue = if (selected) Orange else Color.White
    )

    Button(
        onClick = onClick,
        modifier = Modifier.padding(end = 4.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        border = BorderStroke(width = 2.dp, color = borderColor)
    ) {
        Text(text = buttonText)
    }
}



@Composable
fun RowIconText(
    text: String,
    iconColor: Color,
    painter: Painter,
    modifier: Modifier = Modifier,
    iconSize: Dp = 20.dp,
    textColor: Color = GGrey,
    iconContentDescription: String? = null
) {
    Row(modifier = modifier) {
        Icon(
            painter = painter,
            contentDescription = iconContentDescription,
            modifier = Modifier
                .size(iconSize)
                .padding(end = 4.dp),
            tint = iconColor
        )
        Text(text = text, color = textColor)
    }
}