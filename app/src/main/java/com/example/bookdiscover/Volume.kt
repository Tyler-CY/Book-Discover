package com.example.bookdiscover

import com.squareup.moshi.Json

data class Volume (
    val id: String,
    @Json(name = "volumeInfo.title") val title: String,
    @Json(name = "volumeInfo.averageRating") val rating: Double
)
