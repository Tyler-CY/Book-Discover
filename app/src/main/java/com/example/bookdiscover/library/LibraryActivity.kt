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

        setUpToolBar()

        val toolbar = findViewById<Toolbar>(R.id.tool_bar_widget)
        toolbar.subtitle = "Your Collection"
    }
}