package com.example.bookdiscover.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import com.example.bookdiscover.database.AppDatabase
import com.example.bookdiscover.databinding.FragmentLibraryBinding
import kotlinx.coroutines.launch

/**
 * The main fragment used in LibraryActivity
 */
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


        /**
         * Use a coroutineScope to get the Flow data from the DAO of the sharedViewModel.
         * TODO: Might not be a good idea to use a new LibraryAdapter every time "bookmarks" updates. Try
         * TODO: to mimic the implementation used in GenreFragment.
         */
        lifecycle.coroutineScope.launch {
            sharedViewModel.bookmarks().collect {

                // Access the RecyclerView.
                val recyclerView = binding.libraryRecyclerView

                recyclerView.adapter = LibraryAdapter(this@LibraryFragment.activity!!, it)
            }
        }


        // Inflate the layout for this fragment
        return binding.root
    }

}