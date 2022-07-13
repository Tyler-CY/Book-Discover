package com.example.bookdiscover.genre

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookdiscover.network.GoogleBooksApi
import com.example.bookdiscover.network.Volume
import com.example.bookdiscover.network.VolumeQueryResult
import kotlinx.coroutines.launch

class GenreImageViewModel(
    genreNameList: List<String>
): ViewModel() {

    // The list of volumes, each representing its genre
    private val _representatives = MutableLiveData<List<Volume>>()
    val representatives: LiveData<List<Volume>> = _representatives

    val genreNameDataset = genreNameList
    /**
     * Initialize the view model
     */
    // TODO: This function crashes
    // TODO: com.squareup.moshi.JsonDataException: Required value 'items' missing at $
    fun initialize(){
        viewModelScope.launch {
            var queryResult: VolumeQueryResult
            genreNameDataset.forEach {
                try{
                    queryResult = GoogleBooksApi.retrofitService.search("subject:" + it)
                } catch (e: Exception){
                    queryResult = VolumeQueryResult("gg", 0, listOf())
                }

                Log.d("QUERY", queryResult.toString())
                val itemToBeAdded: Volume
                if (queryResult.totalItems == 0){
                    itemToBeAdded = Volume("")
                }
                else {
                    itemToBeAdded = queryResult.items[0]
                }
                 _representatives.value = _representatives.value?.plus(itemToBeAdded) ?: listOf(itemToBeAdded)
            }
        }
    }
}