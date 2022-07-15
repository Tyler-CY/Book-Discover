package com.example.bookdiscover.database

import android.app.Application

class BookDiscoverApplication: Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this)}
}