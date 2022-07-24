package com.example.bookdiscover.library

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bookdiscover.R
import com.example.bookdiscover.database.AppDatabase
import com.example.bookdiscover.database.Bookmarks
import com.example.bookdiscover.database.LibraryDao
import com.example.bookdiscover.databinding.FragmentGenreBinding
import com.example.bookdiscover.databinding.FragmentLibraryBinding
import com.example.bookdiscover.genre.GenreAdapter
import com.example.bookdiscover.network.Volume
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


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

        sharedViewModel.getAllSavedVolumes()

        lifecycle.coroutineScope.launch {
            sharedViewModel.bookmarks().collect(){

                val recyclerView = binding.libraryRecyclerView

                val testVolumes = listOf(Volume("1"), Volume("1"),Volume("1"),Volume("1"),Volume("1"))
                val testBookmarks = it

                recyclerView.adapter = LibraryAdapter(this@LibraryFragment.activity!!, testVolumes, testBookmarks)
            }
        }
//        sharedViewModel.bookmarks.observe(this){
//            val recyclerView = binding.libraryRecyclerView
//
////            Log.d("Observer", "testVolumes")
////             val testVolumes = sharedViewModel.volumes.value!!
//            val testVolumes = listOf(Volume("1"), Volume("1"),Volume("1"),Volume("1"),Volume("1"))
//            val testBookmarks = sharedViewModel.bookmarks.value!!
////            if (testBookmarks.size == 0){
////                testBookmarks = listOf(Bookmarks("No Bookmarks Available"))
////            }
//
////
//            recyclerView.adapter = LibraryAdapter(this@LibraryFragment.activity!!, testVolumes, testBookmarks)
//        }



        // Inflate the layout for this fragment
        return binding.root
    }

}