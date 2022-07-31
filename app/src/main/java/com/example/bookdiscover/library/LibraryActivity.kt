package com.example.bookdiscover.library

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.bookdiscover.BaseActivity
import com.example.bookdiscover.R

/**
 * The activity class for showing the user's library.
 */
class LibraryActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        // Use the toolbar widget instead of the appbar
        val toolbar = findViewById<Toolbar>(R.id.tool_bar_widget)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Must have the following line for Up button to work!!
        toolbar.setNavigationOnClickListener { onBackPressed() }

        toolbar.subtitle = "Your Collection"
    }
}