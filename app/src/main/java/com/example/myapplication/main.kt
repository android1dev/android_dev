package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.spinwheelslider.SpinWheelSliderApp

private val Any.background: Color
    get() {
        TODO("Not yet implemented")
    }

private val Any.colors: Any
    get() {
        TODO("Not yet implemented")
    }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpinWheelSliderTheme {
                Surface(color = MaterialTheme.colors.background) {
                    SpinWheelSliderApp()
                }
            }
        }
    }

    private fun MaterialTheme(): Any {
        TODO("Not yet implemented")
    }
}

class SpinWheelSliderTheme(function: @Composable () -> Unit) {

}

@Preview
@Composable
fun PreviewSpinWheelSliderApp() {
    SpinWheelSliderTheme {
        Surface {
            SpinWheelSliderApp()
        }
    }
}
