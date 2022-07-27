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

        val recyclerView = binding.genreRecyclerView
        recyclerView.layoutManager = GridLayoutManager(this@GenreFragment.activity!!, 3)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = GenreAdapter(this@GenreFragment.activity!!)



        sharedViewModel.genres.observe(this) {
            if (it != null) {

                val newestItem = it.last()
                val list = this@GenreFragment.activity!!.resources.getStringArray(R.array.subjects).toList()
                val newestItemIndex = list.indexOf(newestItem)

                // Updates the dataset of adapter (i.e. the image URL mapping)
                (recyclerView.adapter as GenreAdapter).setImageUrls(sharedViewModel.representatives.value!!)


                recyclerView.adapter!!.notifyItemChanged(newestItemIndex)
            }
        }


        // Inflate the layout for this fragment
        return binding.root
    }
}