package com.example.bookdiscover.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.bookdiscover.network.Volume

@Database(entities = arrayOf(Bookmarks::class), exportSchema = false, version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun libraryDao(): LibraryDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}