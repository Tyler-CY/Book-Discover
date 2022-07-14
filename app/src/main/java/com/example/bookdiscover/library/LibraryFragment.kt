package com.example.bookdiscover.library

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bookdiscover.R
import com.example.bookdiscover.databinding.FragmentGenreBinding
import com.example.bookdiscover.databinding.FragmentLibraryBinding
import com.example.bookdiscover.genre.GenreAdapter
import com.example.bookdiscover.network.Volume


class LibraryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        }

        // Inflate the layout for this fragment
        return binding.root
    }

}