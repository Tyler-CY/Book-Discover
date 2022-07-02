package com.example.bookdiscover.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VolumeQueryResult (
    @Json(name = "kind")
    val kind: String, // Should be "books#volumes"

    @Json(name = "totalItems")
    val totalItems: Int,

    @Json(name = "items")
    val items: List<Volume>
)
