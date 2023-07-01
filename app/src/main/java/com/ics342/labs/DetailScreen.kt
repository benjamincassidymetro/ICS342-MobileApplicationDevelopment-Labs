package com.ics342.labs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.ics342.labs.data.DataItem

@Composable
fun DetailsScreen(
    navController: NavHostController,
    dataItems: List<DataItem>,
    id: Int?
){
    val item: DataItem = GetItemById(dataItems, id = id)!!
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(Screen.Home.route)
            },

    ){
        Text(
            text = "$id",
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = item.name,
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = item.description,
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun GetItemById(dataItems: List<DataItem>, id: Int?): DataItem? {
    return dataItems.find { it.id == id }
}