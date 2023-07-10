package com.ics342.labs

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ics342.labs.ui.theme.LabsTheme
import com.ics342.labs.ui.theme.Screen

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
                    MyApp()
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyApp(){
    val navController = rememberNavController()
    val currentDestination = navController.currentBackStackEntry?.destination?.route
    Scaffold(
        topBar = {
            when (currentDestination) {
                "home_screen" -> { TopAppBar(
                    title = { Text(text = "Weather App") })
                }
                "details_screen" -> { TopAppBar(
                    title = { Text("Forecast") })
                }
            }
        },
        content = {
            NavHost(navController, startDestination = "home_screen") {
                composable("home_screen") { HomeScreen(navController) }
                composable("details_screen") { DetailsScreen(navController) }
            }
        }
    )
}




@Composable
fun HomeScreen(navController: NavController) {
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
        Button(onClick = { navController.navigate("details_screen") }) {
            Text("Go to Details Screen")
        }
    }
}


@Composable
fun DetailsScreen(navController: NavController){
    val forecastItems = listOf(
        DayForecast(20, 3, 5, ForestTemp(12.45F, 32.45F, 43.45F), 23.2F, 23),
        DayForecast(10, 1, 2, ForestTemp(6.78F, 16.78F, 26.78F), 13.4F, 23),
        DayForecast(15, 2, 4, ForestTemp(9.23F, 29.23F, 39.23F), 17.8F, 23),
        DayForecast(25, 3, 6, ForestTemp(15.67F, 35.67F, 45.67F), 20.1F, 23),
        DayForecast(18, 4, 8, ForestTemp(11.34F, 31.34F, 41.34F), 18.9F, 23),
        DayForecast(12, 5, 10, ForestTemp(8.92F, 28.92F, 38.92F), 16.3F, 23),
        DayForecast(21, 6, 12, ForestTemp(13.76F, 33.76F, 43.76F), 19.7F, 23),
        DayForecast(17, 7, 14, ForestTemp(10.87F, 30.87F, 40.87F), 17.2F, 23),
        DayForecast(23, 8, 16, ForestTemp(14.58F, 34.58F, 44.58F), 21.5F, 23),
        DayForecast(14, 9, 18, ForestTemp(8.01F, 28.01F, 38.01F), 15.6F, 23),
        DayForecast(19, 10, 20, ForestTemp(12.12F, 32.12F, 42.12F), 18.3F, 23),
        DayForecast(16, 11, 22, ForestTemp(10.21F, 30.21F, 40.21F), 16.9F, 23),
        DayForecast(27, 12, 24, ForestTemp(16.45F, 36.45F, 46.45F), 22.8F, 23),
        DayForecast(13, 13, 26, ForestTemp(7.34F, 27.34F, 37.34F), 14.5F, 23),
        DayForecast(22, 14, 28, ForestTemp(13.01F, 33.01F, 43.01F), 20.2F, 23),
        DayForecast(20, 15, 30, ForestTemp(12.45F, 32.45F, 43.45F), 23.2F, 23),
    )
    LazyColumn {
        items(forecastItems) { forecastItem ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(2.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sunshine),
                        contentDescription = "My Image",
                        alignment = Alignment.Center,
                        contentScale = ContentScale.FillBounds,
                    )
                    Text(
                        text = "${forecastItem.date}",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(2.dp),
                        fontSize = 10.sp
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Temp: ${forecastItem.temp.day}",
                        fontSize = 7.sp
                    )
                    Row() {
                        Text(
                            text = "High: ${forecastItem.temp.max}",
                            fontSize = 7.sp
                        )
                        Text(
                            text = "Low: ${forecastItem.temp.min}",
                            fontSize = 7.sp
                        )
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Sunrise: ${forecastItem.sunrise}",
                        fontSize = 7.sp
                    )
                    Text(
                        text = "Sunset: ${forecastItem.sunset}",
                        fontSize = 7.sp
                    )
                }/*
       Text(
         text = "${dayForecast.date}, " +
                "${dayForecast.humidity}, " +
                "${dayForecast.pressure}, " +
                "${dayForecast.sunrise}, " +
                "${dayForecast.sunset} ",
         modifier = Modifier.padding(16.dp)
       )*/
            }
        }
    }
    Button(onClick = { navController.navigate("home_screen") }) {
        Text("Go to Details Screen")
    }
}


/*
TopBarLayout()
|=====| <-------
|     |
|     |
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarLayout(){
    TopAppBar(
        title = { Text(
            text = stringResource(id = R.string.title),
            color = Color.DarkGray)},
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = Color.LightGray
        ),
    )
}
