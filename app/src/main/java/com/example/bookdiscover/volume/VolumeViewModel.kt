package com.example.bookdiscover.volume

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookdiscover.network.Volume
import kotlinx.coroutines.launch

/**
 * The ViewModel used by the fragments under the "volume" package
 */
class VolumeViewModel : ViewModel() {

    private val _volume = MutableLiveData<Volume>()
    val volume: LiveData<Volume> = _volume

    /**
     * Get a book from the ResultViewModel
     */
    fun initialize(volume: Volume) {
        viewModelScope.launch {
            _volume.postValue(volume)
        }
    }
}