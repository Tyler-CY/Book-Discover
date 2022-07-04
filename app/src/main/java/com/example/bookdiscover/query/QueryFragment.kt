package com.example.bookdiscover.query

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bookdiscover.databinding.FragmentQueryBinding

class QueryFragment : Fragment() {

    // Default code
//    companion object {
//        fun newInstance() = QueryFragment()
//    }
//
//    private lateinit var viewModel: QueryViewModel

    private val viewModel: QueryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentQueryBinding.inflate(inflater)

        // QueryFragment determines the lifecycle of the binding.
        binding.lifecycleOwner = this

        // Give the binding access to the QueryViewModel class
        binding.viewModel = viewModel

//        return inflater.inflate(R.layout.query_fragment, container, false)
        return binding.root
    }
}