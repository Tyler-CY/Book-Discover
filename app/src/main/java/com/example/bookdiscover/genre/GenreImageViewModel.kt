package com.example.bookdiscover.genre

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookdiscover.JSON_IMAGELINKS
import com.example.bookdiscover.JSON_THUMBNAIL
import com.example.bookdiscover.network.GoogleBooksApi
import kotlinx.coroutines.launch

/**
 * The ViewModel shared by the classes in the genre package
 */
class GenreImageViewModel(
    genreNameList: List<String>
) : ViewModel() {

    // representatives and genres could be combined into a SortedMap for convenience.

    // The list of volumes, each representing its genre
    private val _representatives = MutableLiveData<Map<String, String>>()
    val representatives: LiveData<Map<String, String>> = _representatives

    // "genres" is used to identify which genre's query finishes the most recently, so to update the corresponding
    // item view holder in the recyclerView.
    private val _genres = MutableLiveData<List<String>>()
    val genres: LiveData<List<String>> = _genres

    // A String List containing all the genre names.
    private val genreNameDataset = genreNameList


    init {
        initialize()
    }

    private fun initialize() {
        genreNameDataset.forEach {
            getImageLink(it)
        }
    }


    private fun getImageLink(genre: String) {
        viewModelScope.launch {
            try {

                // Query using Google Books Api
                val queryResult = GoogleBooksApi.retrofitService.search("subject:$genre")

                // Extract the image link of the first book
                var imageLink = ""

                // Iterate from the first result and find a book (of that genre) with a book cover.
                // Note all books have book cover images.
                var i = 0
                while (i < queryResult.totalItems && imageLink == "") {
                    imageLink = try {
                        ((queryResult.items[i]).volumeInfo?.get(JSON_IMAGELINKS) as Map<*, *>)[JSON_THUMBNAIL].toString()
                            .replace("http://", "https://")
                    } catch (e: Exception) {
                        ""
                    }
                    i++
                }

                // Updates the map and the lists.
                _representatives.value =
                    _representatives.value?.plus(Pair(genre, imageLink)) ?: mapOf(Pair(genre, imageLink))
                _genres.value = _genres.value?.plus(genre) ?: listOf(genre)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
