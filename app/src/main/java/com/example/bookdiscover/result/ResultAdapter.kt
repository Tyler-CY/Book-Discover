package com.example.bookdiscover.result

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.bookdiscover.R
import com.example.bookdiscover.network.Volume
import com.example.bookdiscover.volume.VolumeActivity

class ResultAdapter (
    private val fragmentActivity: FragmentActivity,
    private val dataset: List<Volume>
    ): RecyclerView.Adapter<ResultAdapter.ItemViewHolder>() {

        class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
            val titleView: TextView = view.findViewById(R.id.item_title)
            val authorView: TextView = view.findViewById(R.id.item_author)


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.result_item, parent, false)

            return ItemViewHolder(adapterLayout)
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = dataset[position]
            holder.titleView.text = item.volumeInfo!!.get("title").toString()
            holder.authorView.text = (item.volumeInfo!!.get("authors") as List<String>).get(0).toString()

            holder.titleView.setOnClickListener {
                val intent = Intent(fragmentActivity, VolumeActivity::class.java)
                intent.putExtra("POSITION", position)
                fragmentActivity.startActivity(intent)
            }
        }

        override fun getItemCount(): Int {
            return dataset.size
        }
}