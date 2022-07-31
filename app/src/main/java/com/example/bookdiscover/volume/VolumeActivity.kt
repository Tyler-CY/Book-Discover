package com.example.bookdiscover.volume

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import com.example.bookdiscover.BaseActivity
import com.example.bookdiscover.R

/**
 * The activity responsible for accessing the details of a volume. This activity is called by ResultActivity only.
 */
class VolumeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        // Get the selected Volume from VolumeHolder
        val selectedVolume = VolumeHolder.getVolume()

        // Initialize the volumeViewModel for each fragments of this activity to use
        val volumeViewModel: VolumeViewModel by viewModels()
        volumeViewModel.initialize(selectedVolume)

        val toolbar = findViewById<Toolbar>(R.id.activity_main_toolbar)
        setSupportActionBar(toolbar)
        toolbar.subtitle = "About the book"
    }
}