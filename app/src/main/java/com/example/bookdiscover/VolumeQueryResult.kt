package com.example.bookdiscover

data class VolumeQueryResult (
    val kind: String, // Should be "books#volumes"
    val totalItems: Number,
    val items: List<Volume>
)
