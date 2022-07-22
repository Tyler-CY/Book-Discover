package com.example.bookdiscover.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bookdiscover.R
import com.example.bookdiscover.database.Bookmarks
import com.example.bookdiscover.network.Volume


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
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Inflate the layout
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.result_item, parent, false)

        // Returns the ItemViewHolder after inflating the layout
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.titleView.text = "Position " + position.toString() + bookmarks[position].toString()
    }

    override fun getItemCount(): Int {
        return bookmarks.size
    }
}