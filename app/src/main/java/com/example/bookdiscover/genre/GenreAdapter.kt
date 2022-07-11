package com.example.bookdiscover.genre

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bookdiscover.QUERY_STRING
import com.example.bookdiscover.R
import com.example.bookdiscover.result.ResultActivity

/**
 * The adapter for the RecyclerView in GenreFragment
 */
class GenreAdapter(
    private val fragmentActivity: FragmentActivity
) : RecyclerView.Adapter<GenreAdapter.ItemViewHolder>() {

    // For now, the dataset is the list of genres/subjects, which are stored in a string array.
    private val dataset = fragmentActivity.resources.getStringArray(R.array.subjects).toList() as List<String>

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
        // Get the item at position
        val item = dataset[position]

        holder.textView.text = item

        // Clicking on the image starts ResultActivity which returns the books of that genre
        holder.imageView.setOnClickListener {
            val intent = Intent(fragmentActivity, ResultActivity::class.java)
            intent.putExtra(QUERY_STRING, "subject:" + holder.textView.text)
            fragmentActivity.startActivity(intent)
        }
    }


    /**
     * Returns the total length of dataset (i.e. no. of items in dataset)
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}