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

class LibraryEditor {
    companion object {
        fun addVolumeToLibrary(fragmentActivity: FragmentActivity, item: Volume) {
            CoroutineScope(Dispatchers.IO).launch {
                val dao = AppDatabase.getDatabase(fragmentActivity).libraryDao()

                GoogleBooksApi.retrofitService.searchById(item.id).enqueue(
                    object : Callback<ResponseBody> {
                        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                            // Raw HTTP response string
                            val jsonBody = response.body()?.string()


                            Thread { dao.insert(Bookmarks(item.id, jsonBody ?: "{}")) }.start()
                        }

                        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                            t.printStackTrace()
                        }
                    })
            }
        }
    }

}