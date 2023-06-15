package com.ics342.labs

import android.app.AlertDialog
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ics342.labs.data.DataItem
import com.ics342.labs.ui.theme.LabsTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.AlertDialog

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
                    DataListScreen(dataItems)
                }
            }
        }
    }
}

@Composable
fun DataListScreen(items: List<DataItem>){
    var showDialog by remember { mutableStateOf(false) }
    var dataItem by remember { mutableStateOf<DataItem?>(null) }
    DataItemList(items) { dataItem = it }
    dataItem?.let{
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = {"Hello World!"},
                text = {"Hello World!"},
                confirmButton = { showDialog = false },
                dismissButton = { showDialog = false },
            )
        }
        else dataItem = null

    }

}

@Composable
fun AlertDialog(){

}
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

@Composable
fun DataItemList(
    dataItems: List<DataItem>,
    dataItemClicked: (DataItem) -> Unit
) {
    LazyColumn{
        items(dataItems){ dataItem ->
           Box(
              modifier = Modifier.clickable {
                  dataItemClicked(dataItem)
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
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            DataListScreen(dataItems)
        }
    }
}
