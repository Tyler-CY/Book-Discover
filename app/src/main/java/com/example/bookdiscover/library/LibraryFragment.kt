package com.example.bookdiscover.library

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isVisible
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

                if (it.isNotEmpty()){
                    // Access the RecyclerView.
                    val recyclerView = binding.libraryRecyclerView
                    binding.libraryRecyclerView.isVisible = true
                    recyclerView.adapter = LibraryAdapter(this@LibraryFragment.activity!!, it)
                }
                else {
                    binding.libraryRecyclerView.isVisible = false

                    val textView = TextView(activity!!)
                    textView.text = "No records."
                    textView.textSize = 24F
                    textView.id = View.generateViewId()
                    binding.libraryLayout.addView(textView, 0)

                    // Sets the textView to the middle by using ConstraintSet
                    val constraintSet = ConstraintSet()
                    constraintSet.clone(binding.libraryLayout)
                    constraintSet.connect(textView.id, ConstraintSet.TOP, binding.libraryLayout.id, ConstraintSet.TOP)
                    constraintSet.connect(textView.id, ConstraintSet.START, binding.libraryLayout.id, ConstraintSet.START)
                    constraintSet.connect(textView.id, ConstraintSet.END, binding.libraryLayout.id, ConstraintSet.END)
                    constraintSet.connect(textView.id, ConstraintSet.BOTTOM, binding.libraryLayout.id, ConstraintSet.BOTTOM)
                    constraintSet.applyTo(binding.libraryLayout)
                }
            }
        }


        // Inflate the layout for this fragment
        return binding.root
    }

}