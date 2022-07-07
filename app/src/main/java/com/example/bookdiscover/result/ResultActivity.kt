package com.example.bookdiscover.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.bookdiscover.R
import com.example.bookdiscover.SEARCH_NAME

/**
 * The activity class for showing the search result
 */
class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // Default Code
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Navigation Controllers
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_fragment_container) as androidx.navigation.fragment.NavHostFragment
        val navController = navHostFragment.navController
        // Show a title in the app bar based off of the destination's label, and display the Up button whenever you're not on a top-level destination.
        setupActionBarWithNavController(navController)

        // QueryViewModel shared by other volume fragments and QueryActivity
        val sharedViewModel: QueryViewModel by viewModels()

        // Invoke searchByName method in sharedViewModel to search for book based on user's filter
        val queryParameters = intent.getStringExtra(SEARCH_NAME).toString()
        sharedViewModel.searchByName(queryParameters)
    }
}