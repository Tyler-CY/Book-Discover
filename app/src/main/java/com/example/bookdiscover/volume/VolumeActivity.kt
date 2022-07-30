package com.example.bookdiscover.volume

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.bookdiscover.AboutActivity
import com.example.bookdiscover.R
import com.example.bookdiscover.preferences.PreferencesActivity

/**
 * The activity responsible for accessing the details of a volume. This activity is called by ResultActivity only.
 */
class VolumeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume)

        // Get the selected Volume from VolumeHolder
        val selectedVolume = VolumeHolder.getVolume()

        // Initialize the volumeViewModel for each fragments of this activity to use
        val volumeViewModel: VolumeViewModel by viewModels()
        volumeViewModel.initialize(selectedVolume)

        val toolbar = findViewById<Toolbar>(R.id.activity_main_toolbar)
        setSupportActionBar(toolbar)
        toolbar.setSubtitle("About the book")
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