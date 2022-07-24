package com.example.bookdiscover.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.bookdiscover.JSON_Hht2CgAAQBAJ
import com.example.bookdiscover.JSON_Qk4rDwAAQBAJ
import com.example.bookdiscover.JSON_WbZ4OQAACAAJ
import com.example.bookdiscover.JSON_igcfBQAAQBAJ

/**
 * The database responsible for storing user's books (acting as a library).
 */
@Database(entities = [Bookmarks::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Returns the direct access object (DAO).
     */
    abstract fun libraryDao(): LibraryDao

    /**
     * Makes the database a singleton object.
     */
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .addCallback(object : Callback() { // Callback for pre-populating the database using a new thread.
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            Thread { prepopulateDb(getDatabase(context)) }.start()
                        }
                    })
                    .build()
                INSTANCE = instance

                instance
            }
        }

        /**
         * Prepopulate the database with some volumes.
         * Called when the database is first created, i.e. when the app is first installed.
         */
        private fun prepopulateDb(db: AppDatabase) {
            val bookmark1 = Bookmarks("Qk4rDwAAQBAJ", JSON_Qk4rDwAAQBAJ)
            db.libraryDao().insert(bookmark1)
            val bookmark2 = Bookmarks("Hht2CgAAQBAJ", JSON_Hht2CgAAQBAJ)
            db.libraryDao().insert(bookmark2)
            val bookmark3 = Bookmarks("WbZ4OQAACAAJ", JSON_WbZ4OQAACAAJ)
            db.libraryDao().insert(bookmark3)
            val bookmark4 = Bookmarks("igcfBQAAQBAJ", JSON_igcfBQAAQBAJ)
            db.libraryDao().insert(bookmark4)

        }
    }
}
