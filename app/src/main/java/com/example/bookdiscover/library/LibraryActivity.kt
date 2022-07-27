package com.example.bookdiscover.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookdiscover.R

/**
 * The activity class for showing the user's library.
 */
class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)
    }
}