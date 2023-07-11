package com.ics342.labs

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ics342.labs.DayForecast
import com.ics342.labs.ForecastTemp
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@Composable
fun ForecastScreen() {
    val forecastItems = generateForecastItems()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(vertical = 16.dp)
                .padding(start = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.forecast_title),
                style = androidx.compose.ui.text.TextStyle(fontSize = 20.sp, color = Color.Black)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {
            items(forecastItems) { forecast ->
                ForecastRow(forecast)
            }
        }
    }
}

@Composable
fun ForecastRow(forecast: DayForecast) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.sun_icon),
            contentDescription = stringResource(R.string.weather_icon),
            modifier = Modifier
                .size(40.dp)
        )
        Text(getFormattedDate(forecast.date))
        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 1.dp)
                .weight(1f)
        ) {
            Column {
                Text("Temp: ${forecast.temp.day}°")
                Text("High: ${forecast.temp.max}° Low: ${forecast.temp.min}°")
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(start = 10.dp, end = 1.dp)
        ) {
            Text("Sunrise: ${getFormattedTime(forecast.sunrise)}")
            Text("Sunset: ${getFormattedTime(forecast.sunset)}")
        }
    }
}

@Composable
fun getFormattedDate(timestamp: Long): String {
    val dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault())
    val formatter = DateTimeFormatter.ofPattern("MMM d")
    return dateTime.format(formatter)
}

@Composable
fun getFormattedTime(timestamp: Long): String {
    val dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneId.systemDefault())
    val formatter = DateTimeFormatter.ofPattern("h:mma")
    return dateTime.format(formatter)
}

private fun generateForecastItems(): List<DayForecast> {
    val forecastItems = mutableListOf<DayForecast>()
    val currentTime = Instant.now().epochSecond
    val oneDay = 24 * 60

    for (i in 1..16) {
        val timestamp = currentTime + (i * oneDay)
        val temp = ForecastTemp(day = 72, min = 65, max = 80)
        val forecast = DayForecast(
            date = timestamp,
            sunrise = timestamp + (6 * 60),
            sunset = timestamp + (18 * 60),
            temp = temp,
            pressure = 1013.25f,
            humidity = 50
        )
        forecastItems.add(forecast)
    }

    return forecastItems
}