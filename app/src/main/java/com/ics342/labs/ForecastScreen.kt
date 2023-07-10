package com.ics342.labs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.lang.Math.round
import java.time.Instant
import java.time.LocalDateTime
import java.util.TimeZone
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random


@Composable
fun DetailsScreen(navController: NavController){
    val forecastItems = mutableListOf<DayForecast>()
    for (i in 1..16) {
        val timestamp = Random.Default.nextLong(0,214779364+1) // randomizes each time from 1970 to 2038
        val randTemp = Random.Default.nextFloat()*100
        val randTempHigh = randTemp + Random.Default.nextFloat() * (100 - randTemp)
        val randTempLow = randTemp - Random.Default.nextFloat() * (100 - randTemp)
        val randPressure = Random.Default.nextFloat()*100
        val randHumidity = Random.Default.nextInt(0,100)
        val randSunrise = Random.Default.nextLong(5,9)
        val dayForecast = DayForecast(
            date = timestamp,
            sunrise = randSunrise,
            sunset = 5,
            ForestTemp(
                day = randTemp,
                min = randTempLow,
                max = randTempHigh
            ),
            pressure = randPressure,
            humidity = randHumidity
        )
        forecastItems.add(dayForecast)
    }
    LazyColumn {
        items(forecastItems) { forecastItem ->
            ForecastItemRow(forecastItem)
        }

    }

}

@Composable
fun ForecastItemRow(dayForecast: DayForecast){
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
                text = DateConverter(dayForecast.date),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(2.dp),
                fontSize = 10.sp
            )
        }
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Temp: ${String.format("%.1f", dayForecast.temp.day)}°",
                fontSize = 7.sp
            )
            Row() {
                Text(
                    text = "High: ${String.format("%.1f",dayForecast.temp.max)}°",
                    fontSize = 7.sp
                )
                Text(
                    text = "Low: ${String.format("%.1f",dayForecast.temp.min)}°",
                    fontSize = 7.sp
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Sunrise: ${ LocalTime.o}",
                fontSize = 7.sp
            )
            Text(
                text = "Sunset: ${dayForecast.sunset}",
                fontSize = 7.sp
            )
        }
    }
}

fun DateConverter(DateLong: Long): String {
    val triggerTime = LocalDateTime.ofInstant(
        Instant.ofEpochSecond(DateLong),
        TimeZone.getDefault().toZoneId()
    )
    val date: LocalDate = triggerTime.toLocalDate()
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM d")
    return date.format(formatter)
}

