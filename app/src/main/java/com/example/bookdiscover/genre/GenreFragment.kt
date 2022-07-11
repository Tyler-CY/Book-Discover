package com.example.bookdiscover.genre

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bookdiscover.R
import com.example.bookdiscover.databinding.FragmentGenreBinding
import com.example.bookdiscover.result.ResultAdapter


class GenreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Data-binding with XML
        val binding = FragmentGenreBinding.inflate(inflater)

        binding.apply {
            // ResultViewModel determines the lifecycle of the binding.
            lifecycleOwner = viewLifecycleOwner
        }



        val recyclerView = binding.genreRecyclerView
        recyclerView.adapter = GenreAdapter(this@GenreFragment.activity!!)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this@GenreFragment.activity!!, 3)



        // Inflate the layout for this fragment
        return binding.root
    }
}