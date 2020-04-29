package com.bigmeco.mtg

import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.fillMaxWidth
import androidx.ui.layout.padding
import androidx.ui.layout.preferredHeightIn
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.res.loadImageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

@Preview
@Composable
fun SplashView() {

        val imageModifier = Modifier
            .fillMaxWidth()

        Image(
            imageResource(id = R.drawable.ds), modifier = imageModifier,
            contentScale = ContentScale.Crop)

    Column(
    ) {
        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")
    }

}

