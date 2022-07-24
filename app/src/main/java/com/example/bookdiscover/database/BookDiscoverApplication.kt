package com.example.bookdiscover.database

import android.app.Application

/**
 * The application for the database.
 */
class BookDiscoverApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this)}
}