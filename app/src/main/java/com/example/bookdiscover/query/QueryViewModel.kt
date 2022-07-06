package com.example.bookdiscover.query

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookdiscover.network.GoogleBooksApi
import com.example.bookdiscover.network.VolumeQueryResult
import kotlinx.coroutines.launch

enum class GoogleBooksApiStatus { LOADING, ERROR, DONE }

class QueryViewModel : ViewModel() {

    private val _kind = MutableLiveData<String>()
    val kind: LiveData<String> = _kind

    private val _totalItems = MutableLiveData<Int>()
    val totalItems: LiveData<Int> = _totalItems

//    private val _id = MutableLiveData<String>()
//    val id: LiveData<String> = _id
//
//    private val _volumeInfo = MutableLiveData<String>()
//    val volumeInfo: LiveData<String> = _volumeInfo
//
//    private val _userInfo = MutableLiveData<String>()
//    val userInfo: LiveData<String> = _userInfo
//
//    private val _saleInfo = MutableLiveData<String>()
//    val saleInfo: LiveData<String> = _saleInfo
//
//    private val _accessInfo = MutableLiveData<String>()
//    val accessInfo: LiveData<String> = _accessInfo
//
//    private val _searchInfo = MutableLiveData<String>()
//    val searchInfo: LiveData<String> = _searchInfo

    /**
     * Call the API immediately to get its status
     */
    init {
        getTestLinkResult()
    }

    /**
     * A test function which gets some books information from the Books API
     */
    private fun getTestLinkResult(){
        viewModelScope.launch {
            try{
                val queryResult = GoogleBooksApi.retrofitService.testLink()
                _kind.value = queryResult.kind
                _totalItems.value = queryResult.totalItems
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}