package com.example.bookdiscover.result

import android.content.Intent
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
import com.example.bookdiscover.library.LibraryEditor.Companion.addVolumeToLibrary
import com.example.bookdiscover.network.Volume
import com.example.bookdiscover.volume.VolumeActivity
import com.example.bookdiscover.volume.VolumeHolder
import com.google.android.material.snackbar.Snackbar

/**
 * The adapter for the RecyclerView in ResultFragment
 */
class ResultAdapter(
    // Referenced activity is used to start intent
    private val fragmentActivity: FragmentActivity,
    // A List of Volume objects, returned by GoogleBooksApi
    private val dataset: List<Volume>
) : RecyclerView.Adapter<ResultAdapter.ItemViewHolder>() {

    // ViewHolder used in the RecyclerView
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.item_title)
        val authorView: TextView = view.findViewById(R.id.item_author)
        val bookView: ImageView = view.findViewById(R.id.book_cover)
        val insertButton: Button = view.findViewById(R.id.add_item_button)
    }

    /**
     * Set up the ViewHolder using XML layout file
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Inflate the layout
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.result_item, parent, false)

        // Returns the ItemViewHolder after inflating the layout
        return ItemViewHolder(adapterLayout)
    }

    /**
     * Binds object to ViewHolder
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        // TODO: clean this method along with LibraryAdapter
        try {
            item.volumeInfo?.let info@{

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


        // Add a click listener for each title TextView to allow the user to see the details of the book
        holder.titleView.setOnClickListener {
            startVolumeActivity(item)
        }
        holder.bookView.setOnClickListener {
            startVolumeActivity(item)
        }

        // Add a click listener for the reader to add volume to library.
        holder.insertButton.setOnClickListener {
            Snackbar.make(it, "Saved to Library!", Snackbar.LENGTH_SHORT).show()
            addVolumeToLibrary(fragmentActivity, item)
        }
    }

    /**
     * Starts VolumeActivity by specifying the volume selected.
     */
    private fun startVolumeActivity(item: Volume) {
        // Update VolumeHolder to hold the current book selected
        VolumeHolder.setVolume(item)
        // Start the VolumeActivity to inspect the details of the book selected
        val intent = Intent(fragmentActivity, VolumeActivity::class.java)
        // Start the activity after setting up
        fragmentActivity.startActivity(intent)
    }


    /**
     * Returns the total length of dataset (i.e. no. of items in dataset)
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}