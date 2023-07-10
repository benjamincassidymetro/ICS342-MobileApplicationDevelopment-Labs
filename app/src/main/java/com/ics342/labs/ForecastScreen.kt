package com.ics342.labs

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.Instant
import java.time.LocalDateTime
import java.util.TimeZone
import java.time.LocalDate
import java.time.format.DateTimeFormatter
var test_timestamp: Long = 1499070300L
var triggerTime = LocalDateTime.ofInstant(
    Instant.ofEpochSecond(test_timestamp),
    TimeZone.getDefault().toZoneId()
)
var date:LocalDate = triggerTime.toLocalDate()
var formatter:DateTimeFormatter = DateTimeFormatter.ofPattern("MMM d")
var text:String = date.format(formatter)
@Composable
fun ForecastScreen(){
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
    LazyColumn{
        items(forecastItems) { forecastItem ->
            ForcastRow(forecastItem)
        }
    }
    Log.d("args",triggerTime.toString())

}

@Composable
fun ForcastRow(dayForecast: DayForecast){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(2.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.sunshine),
                contentDescription = "My Image",
                alignment = Alignment.Center,
                contentScale = ContentScale.FillBounds,
            )
            Text(
                text = "${dayForecast.date}",
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(2.dp),
                fontSize = 10.sp
            )
        }
       Column(
           verticalArrangement = Arrangement.Center
           ) {
           Text(
               text = "Temp: ${dayForecast.temp.day}",
               fontSize = 7.sp
           )
           Row() {
               Text(
                   text = "High: ${dayForecast.temp.max}",
                   fontSize = 7.sp
               )
               Text(
                   text = "Low: ${dayForecast.temp.min}",
                   fontSize = 7.sp
               )
           }
       }
       Column(
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center
       ){
           Text(
               text = "Sunrise: ${dayForecast.sunrise}",
               fontSize =7.sp
           )
           Text(
               text = "Sunset: ${dayForecast.sunset}",
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Forecast() {
    Scaffold(
        topBar = { TopBarLayout() },
        content = { ForecastScreen() }
    )
}
@Preview
@Composable
fun PreviewForecastScreen() {
    ForecastScreen()
}