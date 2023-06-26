package com.ics342.labs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
/*
TopBarLayout()
|=====| <-------
|     |
|     |
 */
@Composable
fun TopBarLayout(){
    TopAppBar(
        title = { Text(
            text = stringResource(id = R.string.title),
            color = Color.DarkGray)},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.LightGray
        )
    )
}
@Composable
fun AppContentLayout(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center,

        ){
            Text(text = stringResource(id = R.string.location))
        }
        Column {
            Row(
              horizontalArrangement = Arrangement.SpaceBetween,
              modifier = Modifier.fillMaxWidth()

            ){
                Text(text = stringResource(id = R.string.temp), fontSize = 100.sp)
                Image(painter = painterResource(id = R.drawable.sunshine),
                      contentDescription = "My Image",
                      alignment = Alignment.Center,
                      contentScale = ContentScale.FillBounds,
                      modifier = Modifier.size(150.dp)
                    )
            }
            Text(text = stringResource(id = R.string.temp_feel))
        }
        Text(text = stringResource(id = R.string.low_temp))
        Text(text = stringResource(id = R.string.high_temp))
        Text(text = stringResource(id = R.string.humidity))
        Text(text = stringResource(id = R.string.pressure))
    }

}
@Composable
fun DataItemList() {
    MaterialTheme(
    ) {
        Scaffold(
            topBar = { TopBarLayout() },
            content = { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .background(Color(235, 255, 255))

                ) {
                    AppContentLayout()
                }
            }
        )
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
