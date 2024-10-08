package com.example.bookdiscover.result

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookdiscover.network.GoogleBooksApi
import com.example.bookdiscover.network.Volume
import com.example.bookdiscover.network.VolumeQueryResult
import kotlinx.coroutines.launch

/**
 * The ViewModel shared by the classes in the result package
 */
class ResultViewModel: ViewModel(){

    // The total number of items in query result (Unused for now)
    private val _totalItems = MutableLiveData<Int>()
    val totalItems: LiveData<Int> = _totalItems

    // The list of volume in the search result
    private val _items = MutableLiveData<List<Volume>>()
    val items: LiveData<List<Volume>> = _items


    init {
        _items.value = listOf()
    }

    /**
     * Search for a book by name
     */
    fun searchByName(bookName: String) {
        viewModelScope.launch {
            try{

                Log.d("queryString", bookName) // e.g. How to Build a Car+inauthor:Adrian Newey+inpublisher:HarperCollins+isbn:9780008196813

                // Get the query result
                val queryResult = GoogleBooksApi.retrofitService.search(bookName)
                // Unpack the query result into different attributes
                unpackQueryResult(queryResult)

            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }

    private fun unpackQueryResult(queryResult: VolumeQueryResult) {
        _totalItems.value = queryResult.totalItems
        _items.value = queryResult.items
    }
}