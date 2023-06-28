package com.ics342.labs

import android.os.Bundle
import android.view.Surface
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ics342.labs.ui.theme.LabsTheme
import java.time.chrono.JapaneseEra.values

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabsTheme {
                // A surface container using the 'background' color from the theme
                Surface {
                    WeatherApp()
                }
            }
        }
    }

    @Composable
    fun WeatherApp() {
        //Aligns everything under each other
        Column {
            //Create weather app title
            Column(
                modifier = Modifier
                    .background(Color.Blue)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.app_name),
                    fontSize = 20.sp,
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
            }

            //Create top section of screen (city,State)
            Text(
                text = stringResource(R.string.stateCity),
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
            )

            //Create middle section of screen
            //Combine degree, text, & image as one element (row)
            Row {
                //Combine degree & text as one element to the left
                Column {
                    //Create degree
                    Text(
                        text = stringResource(R.string.degree),
                        fontSize = 60.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(200.dp)
                    )

                    //Create text
                    Text(
                        text = stringResource(R.string.text),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.width(200.dp)
                    )
                }

                //Add sunnyweather image
                Image(
                    painter = painterResource(id = R.drawable.sunnyweather),
                    contentDescription = "Sunny Weather Image",
                    modifier = Modifier.size(100.dp)
                )
            }

            //Create bottom section of screen
            Column(
                modifier = Modifier
                    .padding(35.dp)
                    .fillMaxWidth()
            ) {

                //Create lowDegree
                Text(
                    text = stringResource(R.string.lowDegree),
                    fontSize = 18.sp
                )

                //Create highDegree
                Text(
                    text = stringResource(R.string.highDegree),
                    fontSize = 18.sp
                )

                //Create humidity
                Text(
                    text = stringResource(R.string.humidity),
                    fontSize = 18.sp
                )

                //Create pressure
                Text(
                    text = stringResource(R.string.pressure),
                    fontSize = 18.sp
                )
            }

            //End
        }
    }
}