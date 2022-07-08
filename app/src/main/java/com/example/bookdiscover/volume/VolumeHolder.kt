package com.example.bookdiscover.volume

import com.example.bookdiscover.network.Volume

object VolumeHolder {
    private var volume: Volume = Volume("temp")

    fun setVolume(volume: Volume){
        this.volume = volume
    }

    fun getVolume(): Volume{
        return this.volume
    }

}