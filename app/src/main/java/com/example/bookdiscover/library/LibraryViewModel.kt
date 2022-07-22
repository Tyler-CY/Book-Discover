package com.example.bookdiscover.library

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookdiscover.database.Bookmarks
import com.example.bookdiscover.database.LibraryDao
import com.example.bookdiscover.network.Volume
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LibraryViewModel(private val libraryDao: LibraryDao): ViewModel() {

    private val _bookmarks = MutableLiveData<List<Bookmarks>>()
    val bookmarks: LiveData<List<Bookmarks>> = _bookmarks

    init{
        getAllSavedVolumes()
    }

    fun getAllSavedVolumes() {
        CoroutineScope(Dispatchers.IO).launch {
//            _bookmarks.value = libraryDao.getAll()
            _bookmarks.postValue(libraryDao.getAll())
        }
    }
}