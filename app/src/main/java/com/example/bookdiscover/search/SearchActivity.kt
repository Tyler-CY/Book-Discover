package com.example.bookdiscover.search

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.bookdiscover.BaseActivity
import com.example.bookdiscover.R

/**
 * The activity class for user to apply filters to book search
 */
class SearchActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val toolbar = findViewById<Toolbar>(R.id.tool_bar_widget)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Must have the following line for Up button to work!!
        toolbar.setNavigationOnClickListener { onBackPressed() }

        toolbar.subtitle = "Discover a new book"
    }
}