package com.example.bookdiscover.volume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.bookdiscover.R

class VolumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        // Navigation Controllers
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.volume_fragment_container) as androidx.navigation.fragment.NavHostFragment
        val navController = navHostFragment.navController
        // Show a title in the app bar based off of the destination's label, and display the Up button whenever you're not on a top-level destination.
        setupActionBarWithNavController(navController)
    }
}