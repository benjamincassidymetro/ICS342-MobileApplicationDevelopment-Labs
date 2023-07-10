package com.ics342.labs

sealed class Screen(val route: String){
    object Home: Screen(route="main_screen")
    object Details: Screen(route="forecast_screen")

}

