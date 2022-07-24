package com.example.bookdiscover.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Direct access object for the room database for accessing user's bookmarks and volumes.
 */
@Dao
interface LibraryDao {
    @Query("SELECT * FROM library")
    fun getAll(): Flow<List<Bookmarks>>

    @Insert
    fun insert(bookmarks: Bookmarks)

    @Delete
    fun delete(bookmarks: Bookmarks)
}