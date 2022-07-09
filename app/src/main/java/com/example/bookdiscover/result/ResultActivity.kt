package com.example.bookdiscover.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.bookdiscover.R
import com.example.bookdiscover.QUERY_STRING

/**
 * The activity class for showing the search result
 */
class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // Default Code
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Initialize the sharedViewModel by getting query result using GoogleBooksApi
        initializeViewModel()
    }

    /**
     * Called the query method in the shared ViewModel to get query result
     */
    private fun initializeViewModel() {
        // ResultViewModel shared by other volume fragments and ResultActivity
        val sharedViewModel: ResultViewModel by viewModels()

        // Invoke searchByName method in sharedViewModel to search for book based on user's filter
        val queryParameters = intent.getStringExtra(QUERY_STRING).toString()

        // searchByName calls GoogleBooksApi to perform a search
        sharedViewModel.searchByName(queryParameters)
    }
}