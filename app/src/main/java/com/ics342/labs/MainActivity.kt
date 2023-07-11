package com.ics342.labs

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.ics342.labs.ui.theme.LabsTheme
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val jsonData = loadData(resources)
        val data = dataFromJsonString(jsonData)
        setContent {
            LabsTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    /*
                    Display the items from the Json file in a LazyColumn
                     */

                    lazyColumn {
                        for(person in data){

                        }
                    }
                }
            }
        }
    }
}

private fun personView() {

}

private fun loadData(resources: Resources): String {
    return resources
        .openRawResource(R.raw.data)
        .bufferedReader()
        .use { it.readText() }
}

private fun dataFromJsonString(json: String): List<PersonalDetails> {
    val moshi: Moshi = Moshi.Builder().build()
    val jsonAdapter: JsonAdapter<List<PersonalDetails>> = moshi.adapter<List<PersonalDetails>>()
    return jsonAdapter.fromJson(json)
}

//@Composable
//fun DataItemList(dataItems: List<DataItem>, navController : NavController) {
//    /* Create the list here. This function will call DataItemView() */
//    LazyColumn {
//        for(data in dataItems){
//            item{DataItemView(data, navController = navController)}
//        }
//    }
//}

