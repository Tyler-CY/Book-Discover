package com.example.bookdiscover.volume

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookdiscover.network.GoogleBooksApi
import kotlinx.coroutines.launch

class SaleInfoViewModel : ViewModel() {

    // Private MutableLiveData which stores the status of the latest request
    private val _status = MutableLiveData<String>()
    // Public immutable LiveData which is retrieved for latest status
    val status: LiveData<String> = _status

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
                _status.value = "Success: ${queryResult.items[0].saleInfo}"
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}