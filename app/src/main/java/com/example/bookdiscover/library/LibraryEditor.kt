package com.example.bookdiscover.library

import androidx.fragment.app.FragmentActivity
import com.example.bookdiscover.database.AppDatabase
import com.example.bookdiscover.database.Bookmarks
import com.example.bookdiscover.network.GoogleBooksApi
import com.example.bookdiscover.network.Volume
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A helper class which uses a coroutine to add a volume to the library.
 */
class LibraryEditor {

    // Makes the method below static.
    companion object {

        /**
         * Adds a Volume to the database by specifying the context (fragmentActivity) and the Volume item.
         */
        fun addVolumeToLibrary(fragmentActivity: FragmentActivity, item: Volume) {

            // Must use coroutine to access the database.
            CoroutineScope(Dispatchers.IO).launch {

                // Get the direct access object.
                val dao = AppDatabase.getDatabase(fragmentActivity).libraryDao()

                // Enqueue for callback
                GoogleBooksApi.retrofitService.searchById(item.id).enqueue(
                    object : Callback<ResponseBody> {

                        /**
                         * Executed when HTTP response returns.
                         */
                        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                            // Raw HTTP response string. Could be null.
                            val jsonBody = response.body()?.string()

                            // TODO: Use another thread to insert the Volume object to the database. Could be replaced by
                            // a coroutine or use the same coroutine?
                            Thread {
                                try {
                                    dao.insert(Bookmarks(item.id, jsonBody ?: "{}"))
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
                            }.start()
                        }

                        /**
                         * Executed when HTTP response fails.
                         */
                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            t.printStackTrace()
                        }
                    })
            }
        }
    }

}