package com.example.bookdiscover.preferences

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.example.bookdiscover.R
import com.example.bookdiscover.database.AppDatabase
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PreferencesFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)

        val clearLibrary: Preference? = findPreference("clearLibrary")

        clearLibrary?.setOnPreferenceClickListener {

            val alertDialog = AlertDialog.Builder(activity!!)
                .setTitle("Reset Library")
                .setMessage("Are you sure you want to delete all saved books from your library?")
                .setIcon(R.drawable.ic_warning_48px)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Confirm") {
                        _, _ ->
                    CoroutineScope(Dispatchers.IO).launch {
                        Snackbar.make(listView, "Library Reset!", Snackbar.LENGTH_SHORT).show()
                        val dao = AppDatabase.getDatabase(activity!!).libraryDao()
                        dao.deleteAll()
                    }
                }
                .setCancelable(true)
                .create()
            alertDialog.show()



            true
        }
    }


}