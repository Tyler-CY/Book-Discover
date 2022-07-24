package com.example.bookdiscover.genre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bookdiscover.R
import com.example.bookdiscover.databinding.FragmentGenreBinding

/**
 * The main fragment used in GenreActivity
 */
class GenreFragment : Fragment() {

    // The sharedViewModel contains a list of volume, in which each volume represents its genre
    private val sharedViewModel: GenreImageViewModel by activityViewModels {
        GenreImageViewModelFactory(
            resources.getStringArray(
                R.array.subjects
            ).toList()
        )
    }

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

        sharedViewModel.initialize()

        // Set up recyclerView
        // Find the recyclerView
        val recyclerView = binding.genreRecyclerView

        // Bind basic adapter to recyclerView
        recyclerView.adapter = GenreAdapter(this@GenreFragment.activity!!, listOf())

        // Changing the contents of the adapter does not change the height or width of the recyclerView,
        // In fact, users cannot change the contents (i.e. genre types are fixed).
        recyclerView.setHasFixedSize(true)

        // Use GridLayoutManager instead of LinearLayoutManager to create a "grid view"
        recyclerView.layoutManager = GridLayoutManager(this@GenreFragment.activity!!, 3)

        sharedViewModel.representatives.observe(this) {
            // Bind adapter to recyclerView
            recyclerView.adapter?.notifyItemInserted(it.size)
            recyclerView.adapter = GenreAdapter(this@GenreFragment.activity!!, sharedViewModel.representatives.value!!)
        }


        // Inflate the layout for this fragment
        return binding.root
    }
}