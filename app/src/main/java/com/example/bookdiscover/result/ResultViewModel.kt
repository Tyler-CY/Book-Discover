package com.example.bookdiscover.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookdiscover.network.GoogleBooksApi
import com.example.bookdiscover.network.Volume
import kotlinx.coroutines.launch

/**
 * The ViewModel shared by the classes in the result package
 */
class ResultViewModel: ViewModel(){

    // The kind of query
    private val _kind = MutableLiveData<String>()
    val kind: LiveData<String> = _kind

    // The total number of items in query result
    private val _totalItems = MutableLiveData<Int>()
    val totalItems: LiveData<Int> = _totalItems

    // The title of the first book in the query result
    private val _topResultTitle = MutableLiveData<String>()
    val topResultTitle: LiveData<String> = _topResultTitle

    // The list of volume in the search result
    private val _items = MutableLiveData<List<Volume>>()
    val items: LiveData<List<Volume>> = _items



    /**
     * Search for a book by name
     */
    fun searchByName(bookName: String) {
        viewModelScope.launch {
            try{

                // Get the query result
                val queryResult = GoogleBooksApi.retrofitService.searchByName(bookName, "25")
                // Unpack the query result into different attributes
                _kind.value = queryResult.kind
                _totalItems.value = queryResult.totalItems
                _topResultTitle.value = queryResult.items[0].volumeInfo.toString().substring(0, 50)
                _items.value = queryResult.items

            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}