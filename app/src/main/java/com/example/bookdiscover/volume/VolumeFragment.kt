package com.example.bookdiscover.volume

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.bookdiscover.JSON_IMAGELINKS
import com.example.bookdiscover.JSON_THUMBNAIL
import com.example.bookdiscover.R
import com.example.bookdiscover.databinding.FragmentVolumeBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.roundToInt


/**
 * The fragment class which shows the result overview; used in ResultActivity
 */
class VolumeFragment : Fragment() {

    private val volumeViewModel: VolumeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Data-binding with XML
        val binding = FragmentVolumeBinding.inflate(inflater)

        binding.apply {
            // Set the lifecycleOwner
            lifecycleOwner = viewLifecycleOwner

        }

        // TODO: For now, set the text as the title
        volumeViewModel.volumeInfo.observe(viewLifecycleOwner) {

            // Extract the needed information
            val title = it!!["title"].toString()
            val authors = (it["authors"] as List<*>).joinToString()
            val descriptions = it["description"].toString()
            val categories = (it["categories"] as List<*>)[0].toString()
            val language = it["language"].toString()
            val averageRating = it["averageRating"].toString()
            val ratingCounts = it["ratingsCount"].toString()
            val imgUrl = it[JSON_IMAGELINKS]
            val infoLink = it["infoLink"].toString()

            binding.volumeTitle.text = title
            binding.volumeAuthor.text = authors
            binding.volumeDescription.text = descriptions
            binding.volumeCategory.text = categories


            when(language){
                "en" -> {binding.volumeLanguage.text = "Available in English"}
                else -> {binding.volumeLanguage.text = "Not available in English"}
            }


            when(averageRating.substring(0, 1)){
                "0" -> binding.volumeAverageRating.text = "⭐"
                "1" -> binding.volumeAverageRating.text = "⭐"
                "2" -> binding.volumeAverageRating.text = "⭐⭐"
                "3" -> binding.volumeAverageRating.text = "⭐⭐⭐"
                "4" -> binding.volumeAverageRating.text = "⭐⭐⭐⭐"
                "5" -> binding.volumeAverageRating.text = "⭐⭐⭐⭐⭐"
                else -> binding.volumeAverageRating.text = "No ratings available"
            }

            if (ratingCounts != "null"){
                binding.volumeRatingsCount.text = "From " + ratingCounts.toFloat().roundToInt().toString() + " reviews"
            }
            else {
                binding.volumeRatingsCount.text = "No reviews available"
            }

            imgUrl?.let {
                val link = (imgUrl as Map<*, *>)[JSON_THUMBNAIL].toString().replace("http://", "https://")

                // Load the image and setup placeholder and error images
                binding.volumeCoverImg.load(link){
                    placeholder(R.drawable.ic_hourglass_empty_48px)
                    error(R.drawable.ic_broken_image_48px)
                }
            }

            binding.addButton.setOnClickListener {
                Snackbar.make(it, "Book added to Library!", Snackbar.LENGTH_SHORT).show()
            }

            // Initialize buttons
            binding.urlButton.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(infoLink))
                startActivity(intent)
            }
        }



        return binding.root
    }
}