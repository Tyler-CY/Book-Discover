package com.example.bookdiscover.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
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
                    .addCallback(object : Callback(){
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


        private val CALLBACK = object: RoomDatabase.Callback() {

        }

        private fun prepopulateDb(db: AppDatabase){
            val bookmark1 = Bookmarks("Qk4rDwAAQBAJ")
            val bookmark2 = Bookmarks("Hht2CgAAQBAJ")
            db.libraryDao().insert(bookmark1)
            db.libraryDao().insert(bookmark2)
        }
    }
}