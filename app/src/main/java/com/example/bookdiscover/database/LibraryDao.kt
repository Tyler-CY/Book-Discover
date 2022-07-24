package com.example.bookdiscover.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.bookdiscover.network.Volume
import kotlinx.coroutines.flow.Flow


@Dao
interface LibraryDao {
    @Query("SELECT * FROM library")
    fun getAll(): Flow<List<Bookmarks>>

    @Insert
    fun insert(bookmarks: Bookmarks)

    @Delete
    fun delete(bookmarks: Bookmarks)
}