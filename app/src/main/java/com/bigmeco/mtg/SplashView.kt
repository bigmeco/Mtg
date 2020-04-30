package com.bigmeco.mtg

import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.Dp
import androidx.ui.unit.dp


@Preview
@Composable
fun SplashViewTest() {
    SplashView(10F, 360)
}

@Composable
fun SplashView(sensor: Float, screenWidthDp: Int) {

    val imageModifier = Modifier
        .size(Dp(screenWidthDp.toFloat()*4))
        .offset((-sensor*50).dp,0.dp)
    Image(
        imageResource(id = R.drawable.mtgjudge), modifier = imageModifier,
        contentScale = ContentScale.FillWidth
    )

    Column(
    ) {
        Text(text = "Counter demo")

        Text(text = "Clicks: ${sensor}")
    }

}

