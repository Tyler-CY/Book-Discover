package com.example.bookdiscover.result

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
import com.example.bookdiscover.R
import com.example.bookdiscover.network.Volume
import com.example.bookdiscover.volume.VolumeActivity
import com.example.bookdiscover.volume.VolumeHolder

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
        // TODO: Ensure volumeInfo is non-null




        // TODO: don't use try catch and use proper json parsing instead.
        try{
            // Set the title TextView
            holder.titleView.text = item.volumeInfo!!["title"].toString()
            // Set the author TextView
            holder.authorView.text = (item.volumeInfo["authors"] as List<*>)[0].toString()

            // Set the book cover thumbnail in the ImageView
            Log.d("VOLUMEINFO", item.volumeInfo.toString())

            var imgUrl = (item.volumeInfo["imageLinks"] as Map<String, Any?>)["thumbnail"].toString()
            // Replace http:// with https://
            imgUrl = imgUrl.replace("http://", "https://")
            Log.d("imgUrl", imgUrl)

            holder.bookView.load(imgUrl){
                placeholder(R.drawable.ic_hourglass_empty_48px)
                error(R.drawable.ic_broken_image_48px)
            }
        } catch (e: Exception){
            e.printStackTrace()
        }


        // Add a click listener for each title TextView to allow the user to see the details of the book
        holder.titleView.setOnClickListener {
            // Start the VolumeActivity to inspect the details of the book selected
            val intent = Intent(fragmentActivity, VolumeActivity::class.java)
            // VolumeHolder holds the current book selected
            VolumeHolder.setVolume(item)
            // Start the activity after setting up
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