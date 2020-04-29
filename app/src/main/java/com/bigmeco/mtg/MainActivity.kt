package com.bigmeco.mtg

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.ui.core.setContent


class MainActivity : AppCompatActivity() , SensorEventListener {
    private var senSensorManager: SensorManager? = null
    private var senAccelerometer: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                SplashView()

        }
         senSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        senAccelerometer = senSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        senSensorManager!!.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        val mySensor: Sensor? = event?.sensor

        if (mySensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val x: Float = event.values.get(0)
            Log.d("tag",x.toString())
        }
    }

    override fun onResume() {
        super.onResume()
        senSensorManager!!.registerListener(
            this,
            senAccelerometer,
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    override fun onPause() {
        super.onPause()
        senSensorManager!!.unregisterListener(this)
    }
}




