package com.example.bookdiscover

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.example.bookdiscover.genre.GenreActivity
import com.example.bookdiscover.library.LibraryActivity
import com.example.bookdiscover.preferences.PreferencesActivity
import com.example.bookdiscover.search.SearchActivity

/**
 * The starting page of the Android application.
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Use the toolbar widget instead of the appbar
        val toolbar = findViewById<Toolbar>(R.id.activity_main_toolbar)
        setSupportActionBar(toolbar)
        toolbar.subtitle = "Home"

        // This button is responsible for starting SearchActivity
        val searchButton = findViewById<Button>(R.id.search_button)
        searchButton.setOnClickListener{
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        val discoverButton = findViewById<Button>(R.id.discover_button)
        discoverButton.setOnClickListener{
            val intent = Intent(this, GenreActivity::class.java)
            startActivity(intent)
        }

        val libraryButton = findViewById<Button>(R.id.collection_button)
        libraryButton.setOnClickListener{
            val intent = Intent(this, LibraryActivity::class.java)
            startActivity(intent)
        }

        val settingsButton = findViewById<Button>(R.id.settings_button)
        settingsButton.setOnClickListener{
            val intent = Intent(this, PreferencesActivity::class.java)
            startActivity(intent)
        }
    }
}