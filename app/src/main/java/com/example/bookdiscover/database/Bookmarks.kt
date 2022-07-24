package com.example.bookdiscover.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * An object representing a bookmark.
 * A bookmark has two attributes, the id of the volume (from Google Books API) and the JsonBody which represents
 * the volume.
 */
@Entity(tableName = "library")
data class Bookmarks (
    @PrimaryKey
    val id: String, // e.g. Qk4rDwAAQBAJ and Hht2CgAAQBAJ for id
    val JsonBody: String? = null,
)
