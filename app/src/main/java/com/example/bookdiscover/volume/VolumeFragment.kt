package com.example.bookdiscover.volume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.bookdiscover.JSON_IMAGELINKS
import com.example.bookdiscover.JSON_THUMBNAIL
import com.example.bookdiscover.R
import com.example.bookdiscover.databinding.FragmentVolumeBinding

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

            // Initialize buttons
            queryButton.setOnClickListener {
                findNavController().navigate(R.id.action_volumeFragment_to_saleInfoFragment)
            }
        }

        // TODO: For now, set the text as the title
        volumeViewModel.volumeInfo.observe(viewLifecycleOwner) {
            binding.volumeTitle.text = it!!["title"].toString()
            binding.volumeAuthor.text = (it["authors"] as List<*>).joinToString()
            binding.volumeDescription.text = it["description"].toString()
            binding.volumeCategory.text = (it["categories"] as List<*>)[0].toString()
            when(it["language"].toString()){
                "en" -> {binding.volumeLanguage.text = "Available in English"}
            }


            if(it["averageRating"].toString() != "null"){
                var ratingString = ""
                for (i in 0..it["averageRating"].toString().substring(0, 1).toInt()) {
                    ratingString += "⭐"
                }
                binding.volumeAverageRating.text = ratingString
            }


            binding.volumeRatingsCount.text = "From " + it["ratingsCount"].toString() + " reviews"
            val imgUrl = it[JSON_IMAGELINKS]
            imgUrl?.let {
                val link = (imgUrl as Map<*, *>)[JSON_THUMBNAIL].toString().replace("http://", "https://")

                // Load the image and setup placeholder and error images
                binding.volumeCoverImg.load(link){
                    placeholder(R.drawable.ic_hourglass_empty_48px)
                    error(R.drawable.ic_broken_image_48px)
                }
            }
        }

        return binding.root
    }
}