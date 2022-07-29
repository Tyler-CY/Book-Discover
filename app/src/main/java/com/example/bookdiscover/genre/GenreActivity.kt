package com.example.bookdiscover.genre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.bookdiscover.AboutActivity
import com.example.bookdiscover.R
import com.google.android.material.snackbar.Snackbar

/**
 * The activity class for showing the search result
 */
class GenreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genre)

        val toolbar = findViewById<Toolbar>(R.id.activity_main_toolbar)
        setSupportActionBar(toolbar)
        toolbar.setSubtitle("Latest Releases")
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