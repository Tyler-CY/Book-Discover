package com.example.bookdiscover.database

import androidx.room.Dao
import androidx.room.Query
import com.example.bookdiscover.network.Volume

@Dao
interface LibraryDao {
    @Query("SELECT * FROM library")
    fun getAll(): List<Volume>
}