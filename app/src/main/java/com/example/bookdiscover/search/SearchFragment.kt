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
                val parsedQueryString: String = buildQueryStringFromBinding()
                startApiQuery(parsedQueryString)
            }
        }

        return binding.root
    }

    /**
     * Extends the FragmentSearchBinding to parse a query string from what the user has selected and typed on the
     * screen.
     */
    private fun FragmentSearchBinding.buildQueryStringFromBinding(): String {
        // Get the name from the nameText TextView and put it in the intent bundle
        var parsedQueryString: String
        val queryKeywords = queryString.text.toString()
        val queryAuthor = queryAuthor.text.toString()
        val queryPublisher = queryPublisher.text.toString()
        val queryCategory = querySubject.selectedItem.toString()

        // Add the search keywords.
        parsedQueryString = queryKeywords
        // Add the additional parameters, i.e. author(s) and publisher(s).
        parsedQueryString = parseQuery(parsedQueryString, "inauthor", queryAuthor)
        parsedQueryString = parseQuery(parsedQueryString, "inpublisher", queryPublisher)

        // Only parse query if the categories option is not the default value (i.e. "Categories).
        if (queryCategory != "Categories") {
            parsedQueryString = parseQuery(parsedQueryString, "subject", queryCategory)
        }

        // Get the ISBN, LCCN or OCLC type and the corresponding id.
        val queryIdType = queryIdType.selectedItem.toString()
        val queryIdString = queryId.text.toString()
        parsedQueryString = parseQuery(parsedQueryString, queryIdType.lowercase(), queryIdString)

        return parsedQueryString
    }


    /**
     * Starts ResultActivity to begin query according to parsedQueryString.
     */
    private fun startApiQuery(parsedQueryString: String) {
        val intent = Intent(activity, ResultActivity::class.java)
        intent.putExtra(QUERY_STRING, parsedQueryString)
        startActivity(intent)
    }

    /**
     * Update the queryString using the new (queryKey, queryValue) pair
     */
    private fun parseQuery(parsedQueryString: String, queryKey: String, queryValue: String): String {

        if (queryValue.isNotEmpty()){
            return "$parsedQueryString+$queryKey:$queryValue"
        }

        return parsedQueryString
    }
}