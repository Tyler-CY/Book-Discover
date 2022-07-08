package com.example.bookdiscover.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bookdiscover.SEARCH_NAME
import com.example.bookdiscover.databinding.FragmentSearchBinding
import com.example.bookdiscover.result.ResultActivity

/**
 * The main fragment used in SearchActivity
 */
class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Data-binding with XML
        val binding = FragmentSearchBinding.inflate(inflater)

        binding.apply {
            // Set the lifecycleOwner
            lifecycleOwner = viewLifecycleOwner

            // submit button starts the ResultActivity, which calls the GoogleBooksApi to do the query
            submitButton.setOnClickListener {
                val intent = Intent(activity, ResultActivity::class.java)

                // Get the name from the nameText TextView and put it in the intent bundle
                val name = nameText.text.toString()
                intent.putExtra(SEARCH_NAME, name)

                // Start the activity after setting up
                startActivity(intent)
            }
        }

        return binding.root
    }
}