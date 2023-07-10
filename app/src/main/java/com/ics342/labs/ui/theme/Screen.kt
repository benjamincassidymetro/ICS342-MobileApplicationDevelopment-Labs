package com.ics342.labs.ui.theme

sealed class Screen(val route: String){
    object Home: Screen(route="main_screen")
    object Details: Screen(route="forecast_screen")

}

