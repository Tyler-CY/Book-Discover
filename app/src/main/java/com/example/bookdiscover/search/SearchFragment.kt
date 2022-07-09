package com.example.bookdiscover.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bookdiscover.QUERY_STRING
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
                var parsedQueryString = ""
                val queryKeyword = queryString.text.toString()
                val queryAuthor = queryAuthor.text.toString()
                val queryPublisher = queryPublisher.text.toString()
                val queryCategory = querySubject.selectedItem.toString()

                parsedQueryString = queryKeyword
                parsedQueryString = parseQuery(parsedQueryString, "inauthor", queryAuthor)
                parsedQueryString = parseQuery(parsedQueryString, "inpublisher", queryPublisher)


                // TODO: get dropdown menu

                intent.putExtra(QUERY_STRING, parsedQueryString)

                // Start the activity after setting up
                startActivity(intent)
            }
        }

        return binding.root
    }

    private fun parseQuery(parsedQueryString: String, queryKey: String, queryValue: String): String {
        var updatedQueryString = ""

        if (queryValue.length !== 0){
            return parsedQueryString + "+" + queryKey + ":" + queryValue
        }

        return parsedQueryString
    }
}