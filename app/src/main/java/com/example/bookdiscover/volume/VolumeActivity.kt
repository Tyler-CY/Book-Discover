package com.example.bookdiscover.volume

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.bookdiscover.R

/**
 * The activity responsible for accessing the details of a volume. This activity is called by ResultActivity only.
 */
class VolumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // Default
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        // Navigation Controllers
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.volume_fragment_container) as androidx.navigation.fragment.NavHostFragment
        val navController = navHostFragment.navController
        // Show a title in the app bar based off of the destination's label, and display the Up button whenever you're not on a top-level destination.
        setupActionBarWithNavController(navController)

        // Get the selected Volume from VolumeHolder
        val selectedVolume = VolumeHolder.getVolume()

        // Initialize the volumeViewModel for each fragments of this activity to use
        val volumeViewModel: VolumeViewModel by viewModels()
        volumeViewModel.initialize(selectedVolume)

    }
}