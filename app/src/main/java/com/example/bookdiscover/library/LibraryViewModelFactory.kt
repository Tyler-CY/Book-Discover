package com.example.bookdiscover.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bookdiscover.database.LibraryDao

/**
 * The Factory for LibraryViewModelFactory.
 * This class is needed because we want to pass in a parameter to the ViewModel.
 */
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