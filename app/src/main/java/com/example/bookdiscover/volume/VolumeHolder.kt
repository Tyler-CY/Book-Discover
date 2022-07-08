package com.example.bookdiscover.volume

import com.example.bookdiscover.network.Volume

/**
 * A singleton class which holds the current Volume selected from the RecyclerView in ResultActivity
 */
object VolumeHolder {
    // The Volume object stored in this singleton class
    private var volume: Volume = Volume("temp")

    fun setVolume(volume: Volume){
        this.volume = volume
    }

    fun getVolume(): Volume{
        return this.volume
    }

}