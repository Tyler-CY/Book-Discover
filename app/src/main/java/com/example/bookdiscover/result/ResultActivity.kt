package com.example.bookdiscover.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.bookdiscover.R
import com.example.bookdiscover.SEARCH_NAME

/**
 * The activity class for showing the search result
 */
class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // Default Code
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // QueryViewModel shared by other volume fragments and QueryActivity
        val sharedViewModel: ResultViewModel by viewModels()

        // Invoke searchByName method in sharedViewModel to search for book based on user's filter
        val queryParameters = intent.getStringExtra(SEARCH_NAME).toString()
        sharedViewModel.searchByName(queryParameters)
    }
}