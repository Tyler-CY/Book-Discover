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
import com.example.bookdiscover.library.LibraryEditor.Companion.addVolumeToLibrary
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
        volumeViewModel.volume.observe(viewLifecycleOwner) {

            // The code inside the block executes only if volumeViewModel.volume AND volumeInfo is non-null.
            it?.volumeInfo?.let {

                // Extract information of the volume.
                val title = it["title"].toString()
                val authors = (it["authors"] as List<*>).joinToString()
                val descriptions = it["description"].toString()
                val categories = (it["categories"] as List<*>)[0].toString()
                val language = it["language"].toString()
                val averageRating = it["averageRating"].toString()
                val ratingCounts = it["ratingsCount"].toString()
                val imgUrl = it[JSON_IMAGELINKS]
                val infoLink = it["infoLink"].toString()

                // Sets the texts
                binding.volumeTitle.text = title
                binding.volumeAuthor.text = authors
                binding.volumeDescription.text = descriptions
                binding.volumeCategory.text = categories

                when (language) {
                    "en" -> {
                        binding.volumeLanguage.text = "Available in English"
                    }
                    else -> {
                        binding.volumeLanguage.text = "Not available in English"
                    }
                }

                // Sets the average rating of the book to the corresponding view.
                setAverageRating(averageRating, binding)

                // Sets the rating counts of the book to the corresponding view.
                setRatingCounts(ratingCounts, binding)

                // Sets the book cover image of the imageView.
                imgUrl?.let {
                    val link = (imgUrl as Map<*, *>)[JSON_THUMBNAIL].toString().replace("http://", "https://")

                    // Load the image and setup placeholder and error images
                    binding.volumeCoverImg.load(link) {
                        placeholder(R.drawable.ic_hourglass_empty_48px)
                        error(R.drawable.ic_broken_image_48px)
                    }
                }

                // Initialize buttons
                binding.addButton.setOnClickListener {
                    Snackbar.make(it, "Saved to Library!", Snackbar.LENGTH_SHORT).show()
                    addVolumeToLibrary()
                }
                binding.urlButton.setOnClickListener {
                    startGoogleBooksWebActivity(infoLink)
                }
            }


        }


        return binding.root
    }


    /**
     * Starts an implicit intent to launch a browser to view the infoLink.
     */
    private fun startGoogleBooksWebActivity(infoLink: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(infoLink))
        startActivity(intent)
    }

    /**
     * Calls LibraryEditor's static method to add the Volume to the library collection (i.e. to the database).
     */
    private fun addVolumeToLibrary() {
        volumeViewModel.volume.value?.let {
            addVolumeToLibrary(this.activity!!, it)
        }
    }

    /**
     * Set the rating counts onto the corresponding view of the binding.
     */
    private fun setRatingCounts(
        ratingCounts: String,
        binding: FragmentVolumeBinding
    ) {
        if (ratingCounts != "null") {
            binding.volumeRatingsCount.text = "From " + ratingCounts.toFloat().roundToInt().toString() + " reviews"
        } else {
            binding.volumeRatingsCount.text = "No reviews available"
        }
    }

    /**
     * Set the average rating onto the corresponding view of the binding.
     */
    private fun setAverageRating(
        averageRating: String,
        binding: FragmentVolumeBinding
    ) {
        when (averageRating.substring(0, 1)) {
            "0" -> binding.volumeAverageRating.text = "⭐"
            "1" -> binding.volumeAverageRating.text = "⭐"
            "2" -> binding.volumeAverageRating.text = "⭐⭐"
            "3" -> binding.volumeAverageRating.text = "⭐⭐⭐"
            "4" -> binding.volumeAverageRating.text = "⭐⭐⭐⭐"
            "5" -> binding.volumeAverageRating.text = "⭐⭐⭐⭐⭐"
            else -> binding.volumeAverageRating.text = "No ratings available"
        }
    }
}