package com.ics342.labs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ics342.labs.data.DataItem
import com.ics342.labs.ui.theme.LabsTheme

lateinit var navController: NavHostController
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


sealed class Screen(val route: String){
    object Home: Screen(route="home_screen")
    object Details: Screen(route="details_screen")

}

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
                    //NavExample()
                    //DataListScreen(dataItems)
                    MainActivityRun()
                }
            }
        }
    }
}



/*
@Composable
fun DataListScreen(items: List<DataItem>){
    var showDialog by remember { mutableStateOf(false) }
    var dataItem by remember { mutableStateOf<DataItem?>(null) }
    // when selected, it focuses on the specific item and sets showDialog to true
    DataItemList(items) { dataItem = it;
        showDialog=true }
    dataItem?.let{
        // if person clicks on item,
        if (showDialog) {
            AlertDialog(
                // close if user clicks outside the box
                onDismissRequest = { showDialog = false },
                title = { Text("${it.name}") },
                text = { Text("${it.description}") },
                // close if user presses disagree button
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Disagree")
                    }
                },
                // closes if user presses agree button
                confirmButton = {
                    Button(onClick = { showDialog = false } ) {
                        Text("Agree")
                    }
                },
            )
        }
    }
}
*/
/*
=================
id    name
      description
=================
 */
@Composable
fun DataItemView(dataItem: DataItem) {
    Row{
        Text(
            text = dataItem.id.toString(),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Column{
            Text(text = dataItem.name,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(text = dataItem.description,
                style = TextStyle(
                    fontSize =10.sp,
                )
            )
        }
    }
}

/*
==============
dataItemView()
--------------
dataItemView()
--------------
dataItemView()
==============
 */

// this code enables each item to be clickable and puts the view in each column

@Composable
fun DataItemList(dataItems: List<DataItem>) {
    LazyColumn {
        items(dataItems) { dataItem ->
            Box(
                modifier = Modifier.clickable {

                }
            ) {
                DataItemView(dataItem)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LabsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainActivityRun()
        }
    }
}





@Composable
fun HomeScreen(navController : NavController){
    LazyColumn {
        items(dataItems) { dataItem ->
            Box(

            ) {
                Text(
                    text = ,
                    modifier = Modifier.clickable {
                        navController.navigate(route = Screen.Details.route)
                    }
                )
                DataItemView(dataItem)
            }
        }
    }
}
@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(
        navController = rememberNavController()
    )
}

@Composable
fun DetailScreen(
    navController: NavController
){
    Box(
        contentAlignment = Alignment.Center,

    ){
        Text(
            text = "Hello world!",
            modifier = Modifier.clickable {
                navController.navigate(
                    route = Screen.Home.route
                )
            })

    }
}

@Preview
@Composable
fun DetailScreenPreview(){
    DetailScreen(
        navController = rememberNavController()
    )
}

@Composable
fun Setup(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Details.route,
        ){
            DetailScreen(navController = navController)
        }
    }
}

@Composable
fun MainActivityRun(){
    navController = rememberNavController()
    Setup(navController = navController)
}
@Preview
@Composable
fun MainActivityRunPreview(){
    LabsTheme {
        MainActivityRun()
    }
}
