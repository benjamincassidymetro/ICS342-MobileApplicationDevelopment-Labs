package com.ics342.labs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.ics342.labs.data.DataItem

@Composable
fun DetailsScreen(item: DataItem){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Text(
            text = "${item.id}",
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