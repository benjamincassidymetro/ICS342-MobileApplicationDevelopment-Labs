package com.ics342.labs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ics342.labs.data.DataItem

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    dataItems: List<DataItem>,
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController, dataItems)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                }
            )
        ){
            val id = it.arguments?.getInt("id")
            var item: DataItem? = null
            for(data in dataItems){
                if(data.id == id){
                    item = data
                }
            }
            item?.let { it1 -> DetailsScreen(item = it1) }
        }
    }
}