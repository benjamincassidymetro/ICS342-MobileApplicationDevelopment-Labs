package com.ics342.labs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center,

            ){
            Text(text = stringResource(id = R.string.location))
        }
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()

            ){
                Text(text = stringResource(id = R.string.temp), fontSize = 100.sp)
                Image(painter = painterResource(id = R.drawable.sunshine),
                    contentDescription = "My Image",
                    alignment = Alignment.Center,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.size(150.dp)
                )
            }
            Text(text = stringResource(id = R.string.temp_feel))
        }
        Text(text = stringResource(id = R.string.low_temp))
        Text(text = stringResource(id = R.string.high_temp))
        Text(text = stringResource(id = R.string.humidity))
        Text(text = stringResource(id = R.string.pressure))
        Button(onClick = { navController.navigate(Screen.Details.route) }) {
            Text("Forecast")
        }
    }
}
