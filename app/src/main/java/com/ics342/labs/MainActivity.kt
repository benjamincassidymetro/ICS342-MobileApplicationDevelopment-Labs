package com.ics342.labs

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ics342.labs.data.DataItem
import com.ics342.labs.ui.theme.LabsTheme
import java.util.Random


private val dataItems = listOf(
    DataItem(1, "Item 1", "Description 1"),
    DataItem(2, "Item 2", "Description 2"),
    DataItem(3, "Item 3", "Description 3"),
    DataItem(4, "Item 4", "Description 4"),
    DataItem(5, "Item 5", "Description 5"),
    DataItem(6, "Item 6", "Description 6"),
    DataItem(7, "Item 7", "Description 7"),
    DataItem(8, "Item 8", "Description 8"),
    DataItem(9, "Item 9", "Description 9"),
    DataItem(10, "Item 10", "Description 10"),
    DataItem(11, "Item 11", "Description 11"),
    DataItem(12, "Item 12", "Description 12"),
    DataItem(13, "Item 13", "Description 13"),
    DataItem(14, "Item 14", "Description 14"),
    DataItem(15, "Item 15", "Description 15"),
    DataItem(16, "Item 16", "Description 16"),
    DataItem(17, "Item 17", "Description 17"),
    DataItem(18, "Item 18", "Description 18"),
    DataItem(19, "Item 19", "Description 19"),
    DataItem(20, "Item 20", "Description 20"),
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationView()
                }
            }
        }
    }
}


@Composable
fun DataItemView(dataItem: DataItem) {
    Row {
        //Gets the dataItem ID and converts it to a string
        Text(text = dataItem.id.toString())
        Spacer(modifier = Modifier.size(15.dp))

        Column {

            //Gets the dataItem name
            Text(
                text = dataItem.name,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodySmall,
            )
            //Gets the dataItem description
            Text(
                text = dataItem.description,
                style = MaterialTheme.typography.bodySmall,
                fontSize = 3.sp,
            )
        }
    }
}


//Navigation function: home screen and detail screen
@Composable
fun NavigationView() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("Detail") {
            DetailScreen(
                onHome = { navController.popBackStack() }
            )
        }
    }
}


//Creates a list of all the data items making them clickable
//when clicked, moves to a new screen
@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(dataItems) { DataItem ->
                Button(
                    onClick = { navController.navigate("Detail") },
                    colors = ButtonDefaults.buttonColors(Color.Black.copy(alpha = 1F))
                ) { DataItemView(DataItem) }
            }
        }
    }
}

//This function displays the items ID, Name, and Description
@Composable
fun DetailScreen(onHome: () -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text("Detail Screen", fontSize = 40.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Item ID: " + dataItems[0].id.toString())
        Text(text = dataItems[0].name)

        Spacer(modifier = Modifier.height(15.dp))
        Text(text = dataItems[0].description, fontSize = 20.sp)

        Button(onClick = onHome) { Text("Go back to Home Screen") }
    }

}

//function to show the data items **keeping this function for reference**
@Composable
fun DataItemList(dataItems: List<DataItem>) {

    //Creates a function for a column for dataItems.
    LazyColumn {
        items(dataItems) { DataItem ->
            DataItemView(DataItem)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabsTheme {
        NavigationView()
    }
}

