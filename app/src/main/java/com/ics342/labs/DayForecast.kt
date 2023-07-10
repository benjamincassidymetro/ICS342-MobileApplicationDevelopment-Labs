package com.ics342.labs

data class DayForecast(
    val date : Long,
    val sunrise : Long,
    val sunset: Long,
    val temp: ForestTemp,
    val pressure : Float,
    val humidity : Int
)
