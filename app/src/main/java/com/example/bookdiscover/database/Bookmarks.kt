package com.example.bookdiscover.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "library")
data class Bookmarks (
    @PrimaryKey
    val id: String,
    val JsonBody: String? = null,


    // e.g. Qk4rDwAAQBAJ and Hht2CgAAQBAJ for id
)
