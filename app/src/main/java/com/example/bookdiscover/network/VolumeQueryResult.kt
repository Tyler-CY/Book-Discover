package com.example.bookdiscover.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * The data class for the result of the user's search
 */
@JsonClass(generateAdapter = true)
data class VolumeQueryResult(
    // The kind of "JSON objects" returned
    @Json(name = "kind")
    val kind: String, // Should be "books#volumes"

    // The total number of items in "items"
    @Json(name = "totalItems")
    val totalItems: Int,

    // A JSON array of Volume JSON objects
    @Json(name = "items")
    val items: List<Volume>
)
