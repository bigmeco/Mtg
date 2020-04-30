package com.bigmeco.mtg

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.MutableState
import androidx.compose.state
import androidx.ui.core.setContent


class MainActivity : AppCompatActivity() , SensorEventListener {
    private var senSensorManager: SensorManager? = null
    private var senAccelerometer: Sensor? = null
    private var sensor: Float? = null

    var amount: MutableState<Float>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var configuration = resources.configuration
        Log.d("tag_dp"," "+configuration.screenWidthDp)

        setContent {
            amount =  state { sensor?:0F }
                SplashView(amount!!.value,configuration.screenWidthDp)

        }
         senSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        senAccelerometer = senSensorManager!!.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)
        senSensorManager!!.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        val mySensor: Sensor? = event?.sensor

        if (mySensor?.type == Sensor.TYPE_ROTATION_VECTOR) {
            val x: Float = event.values.get(1)

            amount?.value = event.values.get(0).toFloat()
            Log.d("tag_sensor","x "+event.values.get(0).toString())
            Log.d("tag_sensor","y "+event.values.get(1).toString())
            Log.d("tag_sensor","z "+event.values.get(2).toString())
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




