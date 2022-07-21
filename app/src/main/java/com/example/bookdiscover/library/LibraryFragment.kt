package com.example.bookdiscover.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bookdiscover.R
import com.example.bookdiscover.database.AppDatabase
import com.example.bookdiscover.database.LibraryDao
import com.example.bookdiscover.databinding.FragmentGenreBinding
import com.example.bookdiscover.databinding.FragmentLibraryBinding
import com.example.bookdiscover.genre.GenreAdapter
import com.example.bookdiscover.network.Volume


class LibraryFragment : Fragment() {

    private val sharedViewModel: LibraryViewModel by activityViewModels {
        LibraryViewModelFactory(
            AppDatabase.getDatabase(activity!!).libraryDao()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Data-binding with XML
        val binding = FragmentLibraryBinding.inflate(inflater)

        binding.apply {
            // ResultViewModel determines the lifecycle of the binding.
            lifecycleOwner = viewLifecycleOwner

            viewModel = sharedViewModel
        }

        val recyclerView = binding.libraryRecyclerView
        recyclerView.adapter = LibraryAdapter(this@LibraryFragment.activity!!, listOf(Volume("1"), Volume("1"),Volume("1"),Volume("1"),Volume("1")))
        recyclerView.setHasFixedSize(true)


        // Inflate the layout for this fragment
        return binding.root
    }

}