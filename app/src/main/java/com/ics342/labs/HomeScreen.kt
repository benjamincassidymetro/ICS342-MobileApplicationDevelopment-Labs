package com.ics342.labs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ics342.labs.data.DataItem

@Composable
fun HomeScreen(
    navController: NavController,
    dataItems: List<DataItem>
){
    LazyColumn {
        items(items = dataItems){
            RowsView(navController = navController, dataItem = it)
        }
    }
}

@Composable
fun RowsView(
    navController: NavController,
    dataItem: DataItem
){
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(route = Screen.Detail.passNameDescription(
                    "${dataItem.id}")
                )
            }
    ){
        Text(
            text = "${dataItem.id}",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}
