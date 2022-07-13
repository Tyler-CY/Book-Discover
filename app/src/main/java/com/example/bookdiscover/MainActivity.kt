package com.example.bookdiscover

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.bookdiscover.genre.GenreActivity
import com.example.bookdiscover.search.SearchActivity
import com.google.android.material.snackbar.Snackbar

/**
 * The starting page of the Android application.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        val trendingButton = findViewById<Button>(R.id.collection_button)
        trendingButton.setOnClickListener{
            Snackbar.make(it, "Bookshelf", Snackbar.LENGTH_SHORT).show()
        }

        val settingsButton = findViewById<Button>(R.id.settings_button)
        settingsButton.setOnClickListener{
            Snackbar.make(it, "Settings", Snackbar.LENGTH_SHORT).show()
        }
    }
}