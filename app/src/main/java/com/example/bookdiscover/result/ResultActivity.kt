package com.example.bookdiscover.result

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import com.example.bookdiscover.BaseActivity
import com.example.bookdiscover.QUERY_STRING
import com.example.bookdiscover.R

/**
 * The activity class for showing the search result
 */
class ResultActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // Default Code
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Initialize the sharedViewModel by getting query result using GoogleBooksApi
        initializeViewModel()

        // Use the toolbar widget instead of the appbar
        val toolbar = findViewById<Toolbar>(R.id.tool_bar_widget)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Must have the following line for Up button to work!!
        toolbar.setNavigationOnClickListener { onBackPressed() }

        toolbar.subtitle = "Result"
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