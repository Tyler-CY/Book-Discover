package com.example.bookdiscover.genre

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.bookdiscover.JSON_IMAGELINKS
import com.example.bookdiscover.JSON_THUMBNAIL
import com.example.bookdiscover.QUERY_STRING
import com.example.bookdiscover.R
import com.example.bookdiscover.network.Volume
import com.example.bookdiscover.result.ResultActivity

/**
 * The adapter for the RecyclerView in GenreFragment
 */
class GenreAdapter(
    // Referenced activity is used to start intent
    private val fragmentActivity: FragmentActivity,
    // A List of Volume objects. Each volume is a representative of its genre (subject/category) and
    // the order is based on the "subjects" string array defined in string.xml
    private val imageDataset: List<Volume>
) : RecyclerView.Adapter<GenreAdapter.ItemViewHolder>() {

    // For now, the dataset is the list of genres/subjects, which are stored in a string array.
    private val genreNameDataset = fragmentActivity.resources.getStringArray(R.array.subjects).toList() as List<String>

    // ViewHolder used in the RecyclerView
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
        Log.d("ADAPTER", imageDataset.toString())
        // Get the item at position
        val item = genreNameDataset[position]

        holder.textView.text = item

        // Clicking on the image starts ResultActivity which returns the books of that genre
        holder.imageView.setOnClickListener {
            val intent = Intent(fragmentActivity, ResultActivity::class.java)
            intent.putExtra(QUERY_STRING, "subject:" + holder.textView.text)
            fragmentActivity.startActivity(intent)
        }

        if (imageDataset.isEmpty()) {
            return
        }

        // Set the image
        try {
            if (imageDataset[position].id != "" && genreNameDataset[position] != "Design") {

                val imageUrl =
                    (imageDataset[position].volumeInfo?.get(JSON_IMAGELINKS) as Map<*, *>)[JSON_THUMBNAIL].toString()
                        .replace("http://", "https://")

                Log.d("ADAPTER IMAGEURL", imageUrl)
                Log.d("ADAPTER GENRE", genreNameDataset[position])
                Log.d("ADAPTER LIST LENGTH", imageDataset.size.toString())
                Log.d("ADAPTER POSITION", position.toString())
                holder.imageView.load(imageUrl) {
                    placeholder(R.drawable.ic_hourglass_empty_48px)
                    error(R.drawable.ic_broken_image_48px)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    /**
     * Returns the total length of dataset (i.e. no. of items in dataset)
     */
    override fun getItemCount(): Int {
        return genreNameDataset.size
    }
}