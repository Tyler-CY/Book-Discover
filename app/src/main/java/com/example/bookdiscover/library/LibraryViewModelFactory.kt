package com.example.bookdiscover.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bookdiscover.database.LibraryDao

class LibraryViewModelFactory (private val libraryDao: LibraryDao): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LibraryViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return LibraryViewModel(libraryDao) as T
        }
        else {
            throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}