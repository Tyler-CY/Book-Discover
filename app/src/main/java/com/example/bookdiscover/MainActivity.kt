package com.example.bookdiscover

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.example.bookdiscover.genre.GenreActivity
import com.example.bookdiscover.library.LibraryActivity
import com.example.bookdiscover.search.SearchActivity
import com.google.android.material.snackbar.Snackbar

/**
 * The starting page of the Android application.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.activity_main_toolbar)
        setSupportActionBar(toolbar)
        toolbar.setSubtitle("Home")

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
            Snackbar.make(it, "Settings", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_info -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_settings -> {
                return true
            }
            else -> {
                super.onOptionsItemSelected(item)
                return true
            }
        }
    }
}