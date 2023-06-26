package com.ics342.labs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ics342.labs.ui.theme.LabsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DataItemList()
                }
            }
        }
    }
}

@Composable
fun DataItemList() {
    MaterialTheme(
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(
                        text = stringResource(id = R.string.title),
                        color = Color.DarkGray)},
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color.LightGray
                    )
                )
            },

        ) {
            Column {
                Text("Hi")
                Text("Hi")
                Text("Hi")
                Text(text = stringResource(id = R.string.location))
                Text(text = stringResource(id = R.string.temp))
                Text(text = stringResource(id = R.string.temp_feel))
                Text(text = stringResource(id = R.string.low_temp))
                Text(text = stringResource(id = R.string.high_temp))
                Text(text = stringResource(id = R.string.humidity))
                Text(text = stringResource(id = R.string.pressure))
            }


         }
        }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DataItemList()
        }
    }
}
