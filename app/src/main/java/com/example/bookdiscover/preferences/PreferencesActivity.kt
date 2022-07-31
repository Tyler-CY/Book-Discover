package com.example.bookdiscover.preferences

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import com.example.bookdiscover.BaseActivity
import com.example.bookdiscover.R

/**
 * The activity class for showing the preferences
 */
class PreferencesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)

        setUpToolBar()

        // Use the toolbar widget instead of the appbar
        val toolbar = findViewById<Toolbar>(R.id.tool_bar_widget)
        toolbar.subtitle = "Settings"
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }
}