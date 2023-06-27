package com.ics342.labs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ics342.labs.data.DataItem
import com.ics342.labs.ui.theme.LabsTheme

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
            val (selectedItem, setSelectedItem) = remember { mutableStateOf<DataItem?>(null) }
            val (showDialog, setShowDialog) = remember { mutableStateOf(false) }

            if (showDialog && selectedItem != null) {
                AlertDialog(
                    onDismissRequest = { setShowDialog(false) },
                    title = { Text(selectedItem!!.name) }, // Use selectedItem safely as we've already checked it's not null
                    text = { Text(selectedItem!!.description) }, // Use selectedItem safely as we've already checked it's not null
                    confirmButton = {
                        Button(onClick = { setShowDialog(false) }) {
                            Text("Okay")
                        }
                    }
                )
            }

            LabsTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    DataItemList(dataItems) { dataItem ->
                        setSelectedItem(dataItem)
                        setShowDialog(true)
                    }
                }
            }
        }
    }
}

@Composable
fun DataItemView(dataItem: DataItem, onItemClicked: (DataItem) -> Unit) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier.clickable { onItemClicked(dataItem) }
    ) {
        Text(
            text = dataItem.id.toString(),
            modifier = Modifier.weight(1f),
            fontSize = 18.sp
        )
        Column(modifier = Modifier.weight(3f)) {
            Text(
                text = dataItem.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = dataItem.description,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun DataItemList(dataItems: List<DataItem>, onItemClicked: (DataItem) -> Unit) {
    LazyColumn {
        items(dataItems) { dataItem ->
            DataItemView(dataItem, onItemClicked)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDataItemList() {
    LabsTheme {
        DataItemList(dataItems) {}
    }
}
