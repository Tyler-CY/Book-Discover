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
import com.example.bookdiscover.QUERY_STRING
import com.example.bookdiscover.R
import com.example.bookdiscover.result.ResultActivity

/**
 * The adapter for the RecyclerView in GenreFragment
 */
class GenreAdapter(
    // Referenced activity is used to start intent
    private val fragmentActivity: FragmentActivity,
    // A List of Volume objects. Each volume is a representative of its genre (subject/category) and
    // the order is based on the "subjects" string array defined in string.xml
    imageDataset: Map<String, String>
) : RecyclerView.Adapter<GenreAdapter.ItemViewHolder>() {

    // For now, the dataset is the list of genres/subjects, which are stored in a string array.
    private val genreNameDataset = fragmentActivity.resources.getStringArray(R.array.subjects).toList() as List<String>
    private var imageUrls = imageDataset
//    private val genreImageUrls: MutableMap<String, String> = imageDataset

    fun setImageUrls(map: Map<String, String>){
        imageUrls = map
        Log.e("Observe NEW LIST", imageUrls.toString())
    }

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
        val item = genreNameDataset[position]

        holder.textView.text = item

        // Clicking on the image starts ResultActivity which returns the books of that genre
        holder.imageView.setOnClickListener {
            val intent = Intent(fragmentActivity, ResultActivity::class.java)
            intent.putExtra(QUERY_STRING, "subject:" + holder.textView.text)
            fragmentActivity.startActivity(intent)
        }
        holder.textView.setOnClickListener {
            val intent = Intent(fragmentActivity, ResultActivity::class.java)
            intent.putExtra(QUERY_STRING, "subject:" + holder.textView.text)
            fragmentActivity.startActivity(intent)
        }


        // Set the image
        try {
            val imageUrl = imageUrls.get(item)
            Log.e("Observe imageUrl", imageUrl.toString())
            Log.e("Observe reps on adapter", imageUrls.toString())
            if (imageUrl != null){
                holder.imageView.load(imageUrl) {
                        placeholder(R.drawable.ic_hourglass_empty_48px)
                        error(R.drawable.ic_broken_image_48px)
                }
            }



//            val imageUrl = genreImageUrls.get(item)
//
//            if (imageUrl != null){
//                holder.imageView.load(imageUrl) {
//                    placeholder(R.drawable.ic_hourglass_empty_48px)
//                    error(R.drawable.ic_broken_image_48px)
//                }
//            }
//            else {
//            CoroutineScope(Dispatchers.IO).launch {
//                try {
//                    val queryResult = GoogleBooksApi.retrofitService.search("subject:$item")
//
//                    val imageUrl =
//                        ((queryResult.items[0]).volumeInfo?.get(JSON_IMAGELINKS) as Map<*, *>)[JSON_THUMBNAIL].toString()
//                            .replace("http://", "https://")
//
//                    genreImageUrls.put(item, imageUrl)
//                    holder.imageView.load(imageUrl) {
//                        placeholder(R.drawable.ic_hourglass_empty_48px)
//                        error(R.drawable.ic_broken_image_48px)
//                    }
//                }
//                catch (e: Exception){
//                    e.printStackTrace()
//                }
//
//            }
//            }

//            Log.e("imageUrls", imageDataset.toString())




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

//    private fun extractImageUrl(queryString: VolumeQueryResult,position: Int) =
//        (queryString.items[0]).volumeInfo?.get(JSON_IMAGELINKS) as Map<*, *>)[JSON_THUMBNAIL].toString()
//            .replace("http://", "https://")
}