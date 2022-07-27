package com.example.bookdiscover.volume

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.bookdiscover.R

/**
 * The activity responsible for accessing the details of a volume. This activity is called by ResultActivity only.
 */
class VolumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        // Get the selected Volume from VolumeHolder
        val selectedVolume = VolumeHolder.getVolume()

        // Initialize the volumeViewModel for each fragments of this activity to use
        val volumeViewModel: VolumeViewModel by viewModels()
        volumeViewModel.initialize(selectedVolume)

    }
}