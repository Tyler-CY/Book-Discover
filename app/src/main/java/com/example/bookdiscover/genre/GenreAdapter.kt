package com.example.bookdiscover.genre

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bookdiscover.QUERY_STRING
import com.example.bookdiscover.R
import com.example.bookdiscover.result.ResultActivity
import java.util.*

class GenreAdapter(
    private val fragmentActivity: FragmentActivity

) : RecyclerView.Adapter<GenreAdapter.ItemViewHolder>() {

    val dataset = fragmentActivity.resources.getStringArray(R.array.subjects).toList() as List<String>

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.genre_image)
        val textView: TextView = view.findViewById(R.id.genre_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Inflate the layout
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.genre_item, parent, false)

        // Returns the ItemViewHolder after inflating the layout
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        holder.textView.text = item

        holder.imageView.setOnClickListener {
            val intent = Intent(fragmentActivity, ResultActivity::class.java)
            intent.putExtra(QUERY_STRING, "subject:" + holder.textView.text)
            fragmentActivity.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }


}