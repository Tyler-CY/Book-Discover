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
import coil.load
import com.example.bookdiscover.*
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

/**
 * The adapter for the RecyclerView in ResultFragment.
 *
 * Currently, onBindViewHolder converts the JsonBody to a Volume object before updating the UI. This should be removed
 * in the next version as this is the responsibility of the ViewModel.
 */
class LibraryAdapter(
    // Referenced activity is used to start intent
    private val fragmentActivity: FragmentActivity,
    // For testing, use Bookmarks
    private val bookmarks: List<Bookmarks>

) : RecyclerView.Adapter<LibraryAdapter.ItemViewHolder>() {

    /**
     * ViewHolder used in the RecyclerView.
     * Holder contains a view each for the title, author(s), book cover, and a delete button.
     */
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.item_title)
        val authorView: TextView = view.findViewById(R.id.item_author)
        val bookView: ImageView = view.findViewById(R.id.book_cover)
        val deleteButton: Button = view.findViewById(R.id.delete_button)
    }

    /**
     * Set up the ViewHolder using XML layout file
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Inflate the layout
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.library_item, parent, false)

        // Returns the ItemViewHolder after inflating the layout
        return ItemViewHolder(adapterLayout)
    }

    /**
     * Update the ViewHolder according to its position.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        Log.e("Json", bookmarks[position].JsonBody.toString())
        val item: Volume? = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
            .adapter(Volume::class.java)
            .fromJson(bookmarks[position].JsonBody.toString())

        Log.e("Json", item.toString())

        extractVolumeInfoToUi(item, holder)

        holder.titleView.setOnClickListener {
            // VolumeHolder holds the current book selected
            VolumeHolder.setVolume(item!!)
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


    /**
     * Returns the total length of dataset (i.e. no. of bookmarks)
     */
    override fun getItemCount(): Int {
        return bookmarks.size
    }


    /**
     * Helper Function for extracting needed info (title, author, book cover, delete info) from a Volume object.
     */
    private fun extractVolumeInfoToUi(
        item: Volume?,
        holder: ItemViewHolder
    ) {
        try {
            item?.volumeInfo?.let info@{

                // Update the TextViews below

                val imgUrl = it[JSON_IMAGELINKS]
                imgUrl?.let {
                    val link = (imgUrl as Map<*, *>)[JSON_THUMBNAIL].toString().replace("http://", "https://")

                    // Load the image and setup placeholder and error images
                    holder.bookView.load(link) {
                        placeholder(R.drawable.ic_hourglass_empty_48px)
                        error(R.drawable.ic_broken_image_48px)
                    }
                }

                val title = it[JSON_TITLE]
                title?.let {
                    // Set the title TextView
                    holder.titleView.text = title.toString()
                }

                val authors = it[JSON_AUTHORS]
                authors?.let {
                    val length = (authors as List<*>).size
                    when (length) {
                        1 -> {
                            holder.authorView.text = authors[0].toString()
                        }
                        2 -> {
                            holder.authorView.text = authors[0].toString() + ", " + authors[1].toString()
                        }
                        else -> {
                            holder.authorView.text = authors[0].toString() + ", " + authors[1].toString() + " et al."
                        }
                    }
                }


            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}