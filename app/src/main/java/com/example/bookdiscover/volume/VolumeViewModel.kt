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

    private val _id = MutableLiveData<String>()
    val id: LiveData<String> = _id

    private val _volumeInfo = MutableLiveData<Map<String, Any?>?>()
    val volumeInfo: LiveData<Map<String, Any?>?> = _volumeInfo

    private val _userInfo = MutableLiveData<Map<String, Any?>?>()
    val userInfo: LiveData<Map<String, Any?>?> = _userInfo

    private val _saleInfo = MutableLiveData<Map<String, Any?>?>()
    val saleInfo: LiveData<Map<String, Any?>?> = _saleInfo

    private val _accessInfo = MutableLiveData<Map<String, Any?>?>()
    val accessInfo: LiveData<Map<String, Any?>?> = _accessInfo

    private val _searchInfo = MutableLiveData<Map<String, Any?>?>()
    val searchInfo: LiveData<Map<String, Any?>?> = _searchInfo


    /**
     * Get a book from the ResultViewModel
     */
    fun initialize(volume: Volume) {
        viewModelScope.launch {
            try{
                // Update the values
                _id.value = volume.id
                _volumeInfo.value = volume.volumeInfo
                _userInfo.value = volume.userInfo
                _saleInfo.value = volume.saleInfo
                _accessInfo.value = volume.accessInfo
                _searchInfo.value = volume.searchInfo
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}