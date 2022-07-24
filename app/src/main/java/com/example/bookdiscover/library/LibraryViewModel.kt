package com.example.bookdiscover.library

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookdiscover.database.Bookmarks
import com.example.bookdiscover.database.LibraryDao
import com.example.bookdiscover.network.GoogleBooksApi
import com.example.bookdiscover.network.Volume
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class LibraryViewModel(private val libraryDao: LibraryDao): ViewModel() {

//    private val _bookmarks = MutableLiveData<List<Bookmarks>>()
//    val bookmarks: LiveData<List<Bookmarks>> = _bookmarks

//        val bookmarks: Flow<List<Bookmarks>> = libraryDao.getAll()
//    private val _volumes = MutableLiveData<List<Volume>>()
//    val volumes: LiveData<List<Volume>> = _volumes

//    init{
//        getAllSavedVolumes()
//    }



    fun bookmarks(): Flow<List<Bookmarks>> = libraryDao.getAll()


    fun getAllSavedVolumes() {
        CoroutineScope(Dispatchers.IO).launch {
//            _bookmarks.value = libraryDao.getAll()
//            _bookmarks.postValue(libraryDao.getAll())]



//            val bm = libraryDao.getAll()
//            Log.d("LENGTH", bm.size.toString())
//            val bks = listOf<Volume>()
//            bm.forEach {
////                if (it.JsonBody == null){
//                    val queryResult = GoogleBooksApi.retrofitService.searchById(it.id)
//                    bks.plus(queryResult)
//                Log.d("LENGTH2", bks.size.toString())
////                }
//            }

//            _volumes.postValue(bks)
//            _volumes.postValue(_volumes.value?.plus(queryResult) ?: listOf(queryResult))
        }
    }
}