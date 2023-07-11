package com.ics342.labs

import com.squareup.moshi.Json

// Add the data classes here.
data class DataItem(
    val id: Integer,
    @Json(name = "give_name")
    val giveName: String,
    @Json(name = "family_name")
    val familyName: String,
    val age: Integer,
)

