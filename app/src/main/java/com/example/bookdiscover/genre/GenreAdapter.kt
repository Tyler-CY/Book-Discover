package com.example.bookdiscover.genre

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.bookdiscover.QUERY_STRING
import com.example.bookdiscover.R
import com.example.bookdiscover.result.ResultActivity

/**
 * The adapter for the RecyclerView in GenreFragment
 */
class GenreAdapter(

    // Referenced activity is used to start intent
    private val fragmentActivity: FragmentActivity,

    ) : RecyclerView.Adapter<GenreAdapter.ItemViewHolder>() {

    // For now, the dataset is the list of genres/subjects, which are stored in a string array.
    private val genreNameDataset = fragmentActivity.resources.getStringArray(R.array.subjects).toList() as List<String>
    private var liveImageUrlMappings = mapOf<String, String>()

    /**
     * Sets liveImageUrlMappings.
     * Used by GenreFragment: whenever the image URL mapping updates, the fragment observes the change
     * and calls this function to update liveImageUrlMappings AND calls adapter.notifyItemChanged to notify the
     * change.
     */
    fun setImageUrls(updatedImageUrlMappings: Map<String, String>) {
        liveImageUrlMappings = updatedImageUrlMappings
    }

    /**
     * ViewHolder used in the RecyclerView
     */
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // ImageView holds the image of the genre
        val imageView: ImageView = view.findViewById(R.id.genre_image)

        // TextView holds the description (name) of the genre
        val textView: TextView = view.findViewById(R.id.genre_text)
    }


    /**
     * Set up the ViewHolder using XML layout file
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Inflate the layout
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.genre_item, parent, false)

        // Returns the ItemViewHolder after inflating the layout
        return ItemViewHolder(adapterLayout)
    }


    /**
     * Binds object to ViewHolder
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        // Get the genre string at 'position".
        val genre = genreNameDataset[position]

        // Sets the textView to the genre string.
        holder.textView.text = genre

        // Clicking on the image or the text starts ResultActivity which returns a query result containing
        // the books of that genre.
        holder.imageView.setOnClickListener {
            startResultActivityForGenre(holder, genre)
        }
        holder.textView.setOnClickListener {
            startResultActivityForGenre(holder, genre)
        }


        // Set the image
        try {
            val imageUrl = liveImageUrlMappings[genre]

            if (imageUrl != null) {
                // Loads the image using the Coil library.
                holder.imageView.load(imageUrl) {
                    placeholder(R.drawable.ic_hourglass_empty_48px)
                    error(R.drawable.ic_broken_image_48px)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun startResultActivityForGenre(holder: ItemViewHolder, genre: String) {
        val intent = Intent(fragmentActivity, ResultActivity::class.java)
        intent.putExtra(QUERY_STRING, "subject:" + genre)
        fragmentActivity.startActivity(intent)
    }


    /**
     * Returns the total length of dataset (i.e. no. of items in dataset)
     */
    override fun getItemCount(): Int {
        return genreNameDataset.size
    }
}