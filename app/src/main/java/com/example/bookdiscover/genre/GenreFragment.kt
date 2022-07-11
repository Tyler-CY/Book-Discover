package com.example.bookdiscover.genre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bookdiscover.databinding.FragmentGenreBinding

/**
 * The main fragment used in GenreActivity
 */
class GenreFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Data-binding with XML
        val binding = FragmentGenreBinding.inflate(inflater)

        binding.apply {
            // ResultViewModel determines the lifecycle of the binding.
            lifecycleOwner = viewLifecycleOwner
        }

        // Set up recyclerView
        // Find the recyclerView
        val recyclerView = binding.genreRecyclerView

        // Bind adapter to recyclerView
        recyclerView.adapter = GenreAdapter(this@GenreFragment.activity!!)

        // Changing the contents of the adapter does not change the height or width of the recyclerView,
        // In fact, users cannot change the contents (i.e. genre types are fixed).
        recyclerView.setHasFixedSize(true)

        // Use GridLayoutManager instead of LinearLayoutManager to create a "grid view"
        recyclerView.layoutManager = GridLayoutManager(this@GenreFragment.activity!!, 3)


        // Inflate the layout for this fragment
        return binding.root
    }
}