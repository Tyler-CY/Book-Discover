package com.example.bookdiscover.result

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import com.example.bookdiscover.AboutActivity
import com.example.bookdiscover.R
import com.example.bookdiscover.QUERY_STRING
import com.example.bookdiscover.preferences.PreferencesActivity
import com.google.android.material.snackbar.Snackbar

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

        val toolbar = findViewById<Toolbar>(R.id.activity_main_toolbar)
        setSupportActionBar(toolbar)
        toolbar.setSubtitle("Result")
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
                val intent = Intent(this, PreferencesActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> {
                super.onOptionsItemSelected(item)
                return true
            }
        }
    }
}