package com.example.bookdiscover

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.bookdiscover.preferences.PreferencesActivity

/**
 * The activity class for info page.
 */
class AboutActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        setUpToolBar()

        val toolbar = findViewById<Toolbar>(R.id.tool_bar_widget)
        toolbar.subtitle = "About BookDiscover"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_info -> {
                true
            }
            R.id.action_settings -> {
                val intent = Intent(this, PreferencesActivity::class.java)
                startActivity(intent)
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
                true
            }
        }
    }
}