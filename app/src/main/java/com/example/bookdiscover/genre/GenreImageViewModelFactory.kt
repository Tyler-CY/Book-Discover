package com.example.bookdiscover.genre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * The Factory for GenreImageViewModel
 * This class is needed because we want to pass in a parameter to the ViewModel
 */

class GenreImageViewModelFactory(private val genreList: List<String>) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GenreImageViewModel(genreList) as T
    }
}