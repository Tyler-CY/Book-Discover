package com.example.bookdiscover.genre

import android.text.TextUtils.replace
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookdiscover.JSON_IMAGELINKS
import com.example.bookdiscover.JSON_THUMBNAIL
import com.example.bookdiscover.network.GoogleBooksApi
import com.example.bookdiscover.network.Volume
import com.example.bookdiscover.network.VolumeQueryResult
import kotlinx.coroutines.launch

/**
 * The ViewModel shared by the classes in the genre package
 */
class GenreImageViewModel(
    genreNameList: List<String>
) : ViewModel() {

    // The list of volumes, each representing its genre
    private val _representatives = MutableLiveData<Map<String, String>>()
    val representatives: LiveData<Map<String, String>> = _representatives

    private val _genres = MutableLiveData<List<String>>()
    val genres: LiveData<List<String>> = _genres

    val genreNameDataset = genreNameList
    val genreImageMapping = mutableMapOf<String, String>()

    init{
        _representatives.value = mapOf()
        initialize()
    }

    fun initialize(){
        genreNameDataset.forEach {
            getImageLink(it)
        }
    }



    fun getImageLink(genre: String) {
        viewModelScope.launch {
            try {
                val queryResult = GoogleBooksApi.retrofitService.search("subject:$genre")
                val imageLink =
                    ((queryResult.items[0]).volumeInfo?.get(JSON_IMAGELINKS) as Map<*, *>)[JSON_THUMBNAIL].toString()
                        .replace("http://", "https://")

                _representatives.value = _representatives.value?.plus(Pair(genre, imageLink)) ?: mapOf(Pair(genre, imageLink))
                _genres.value = _genres.value?.plus(genre) ?: listOf(genre)




//                genreImageMapping.put(genre, imageLink)
            } catch (e: Exception) {

//                genreImageMapping.put(genre, "")
            }
        }
    }
}


    /**
     * Initialize the view model
     */
//    // TODO: This function crashes
//    // TODO: com.squareup.moshi.JsonDataException: Required value 'items' missing at $
//    fun initialize(){
//        viewModelScope.launch {
//            var queryResult: VolumeQueryResult
//            genreNameDataset.forEach {
//                queryResult = try{
//                    GoogleBooksApi.retrofitService.search("subject:$it")
//                } catch (e: Exception){
//                    VolumeQueryResult("gg", 0, listOf())
//                }
//
//                Log.d("QUERY", queryResult.toString())
//                val itemToBeAdded: Volume = if (queryResult.totalItems == 0){
//                    Volume("")
//                } else {
//                    queryResult.items[0]
//                }
//                 _representatives.value = _representatives.value?.plus(itemToBeAdded) ?: listOf(itemToBeAdded)
//            }
//        }
//    }
//}