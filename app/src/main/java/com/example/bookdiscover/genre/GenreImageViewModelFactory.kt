package com.example.bookdiscover.genre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GenreImageViewModelFactory(private val genreList: List<String>): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GenreImageViewModel(genreList) as T
    }
}