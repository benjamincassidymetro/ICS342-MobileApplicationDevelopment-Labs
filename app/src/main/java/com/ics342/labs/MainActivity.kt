package com.ics342.labs

import android.os.Bundle
import android.view.Surface
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ics342.labs.ui.theme.LabsTheme

class MainActivity : ComponentActivity() {
    private lateinit var textViewTitle: TextView
    private lateinit var textViewCityName: TextView
    private lateinit var textViewDegree: TextView
    private lateinit var textViewText: TextView
    private lateinit var textViewLow: TextView
    private lateinit var textViewHigh: TextView
    private lateinit var textViewHumidity: TextView
    private lateinit var textViewPressure: TextView
    private lateinit var imageViewWeather: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewTitle = findViewById(R.id.textViewTitle)
        textViewCityName = findViewById(R.id.textViewCityName)
        textViewDegree = findViewById(R.id.textViewDegree)
        textViewText = findViewById(R.id.textViewText)
        textViewLow = findViewById(R.id.textViewLow)
        textViewHigh = findViewById(R.id.textViewHigh)
        textViewHumidity = findViewById(R.id.textViewHumidity)
        textViewPressure = findViewById(R.id.textViewPressure)
        imageViewWeather = findViewById(R.id.imageViewWeather)
    }
}