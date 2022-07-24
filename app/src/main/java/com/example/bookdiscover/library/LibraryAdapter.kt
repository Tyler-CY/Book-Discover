package com.example.bookdiscover.library

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bookdiscover.R
import com.example.bookdiscover.database.AppDatabase
import com.example.bookdiscover.database.Bookmarks
import com.example.bookdiscover.network.Volume
import com.example.bookdiscover.volume.VolumeActivity
import com.example.bookdiscover.volume.VolumeHolder
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher


class LibraryAdapter(
    // Referenced activity is used to start intent
    private val fragmentActivity: FragmentActivity,
    // A List of Volume objects, returned by GoogleBooksApi
    private val dataset: List<Volume>,

    // For testing, use Bookmarks
    private val bookmarks: List<Bookmarks>

) : RecyclerView.Adapter<LibraryAdapter.ItemViewHolder>() {

    // ViewHolder used in the RecyclerView
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.item_title)
        val authorView: TextView = view.findViewById(R.id.item_author)
        val bookView: ImageView = view.findViewById(R.id.book_cover)
        val deleteButton: Button = view.findViewById(R.id.delete_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Inflate the layout
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.library_item, parent, false)

        // Returns the ItemViewHolder after inflating the layout
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Log.e("Json", bookmarks[position].JsonBody.toString())
        val volume: Volume? = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
            .adapter(Volume::class.java)
            .fromJson(bookmarks[position].JsonBody.toString())

        Log.e("Json", volume.toString())

        holder.titleView.text = volume!!.id.toString()

        holder.titleView.setOnClickListener {
            // VolumeHolder holds the current book selected
            VolumeHolder.setVolume(volume)
            // Start the VolumeActivity to inspect the details of the book selected
            val intent = Intent(fragmentActivity, VolumeActivity::class.java)
            // Start the activity after setting up
            fragmentActivity.startActivity(intent)
        }

        holder.deleteButton.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch{
                val dao = AppDatabase.getDatabase(fragmentActivity).libraryDao()
                dao.delete(bookmarks[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return bookmarks.size
    }
}