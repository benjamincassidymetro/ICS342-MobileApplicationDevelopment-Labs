package com.ics342.labs

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ics342.labs.ui.theme.LabsTheme
import com.squareup.moshi.Json
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val jsonData = loadData(resources)
        val data = dataFromJsonString(jsonData)
        setContent {
            LabsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LazyColumn {
                        for (indexMyJsonList in data) {
                            item {
                                DataItemView(indexMyJsonList)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DataItemView(indexMyJsonList: MyJsonData) {
    Row {
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = indexMyJsonList.id.toString(),
            modifier = Modifier.size(70.dp),
            fontSize = 50.sp
        )
        Column {
            Text(
                text = indexMyJsonList.giveName + " " + indexMyJsonList.familyName,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Text(
                text = "Age: " + indexMyJsonList.age.toString(),
                fontSize = 20.sp
            )
        }
    }
}

private fun loadData(resources: Resources): String {
    return resources
        .openRawResource(R.raw.data)
        .bufferedReader()
        .use { it.readText() }
}

@OptIn(ExperimentalStdlibApi::class)
private fun dataFromJsonString(json: String): List<MyJsonData> {
    val moshi: Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val jsonAdapter: JsonAdapter<List<MyJsonData>> = moshi.adapter()
    return jsonAdapter.fromJson(json) ?: listOf()
}

data class MyJsonData (
    @Json(name = "id") val id: Int,
    @Json(name = "give_name") val giveName: String,
    @Json(name = "family_name") val familyName: String,
    @Json(name = "age") val age: Int,
)