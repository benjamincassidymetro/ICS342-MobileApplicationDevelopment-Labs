package com.ics342.labs

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object Detail: Screen(route = "detail_screen/{id}"){
        fun passNameDescription(id: String): String {
            return "detail_screen/$id"
        }
    }
}