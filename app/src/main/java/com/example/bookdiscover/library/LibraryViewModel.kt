package com.example.bookdiscover.library

import androidx.lifecycle.ViewModel
import com.example.bookdiscover.database.Bookmarks
import com.example.bookdiscover.database.LibraryDao
import com.example.bookdiscover.network.Volume

class LibraryViewModel(private val libraryDao: LibraryDao): ViewModel() {
    fun getAllSavedVolumes(): List<Bookmarks> {
        return libraryDao.getAll()
    }
}