package com.example.bookdiscover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Navigation Controllers
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_fragment_container) as androidx.navigation.fragment.NavHostFragment
        val navController = navHostFragment.navController

        // Show a title in the app bar based off of the destination's label, and display the Up button whenever you're not on a top-level destination.
        setupActionBarWithNavController(navController)
    }
}