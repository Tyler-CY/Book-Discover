package com.example.bookdiscover.query

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bookdiscover.R
import com.example.bookdiscover.databinding.FragmentQueryBinding

class QueryFragment : Fragment() {

    // Default code
//    companion object {
//        fun newInstance() = QueryFragment()
//    }
//
//    private lateinit var viewModel: QueryViewModel

    private val sharedViewModel: QueryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentQueryBinding.inflate(inflater)

        // QueryFragment determines the lifecycle of the binding.
        binding.lifecycleOwner = viewLifecycleOwner

        // Give the binding access to the QueryViewModel class
        binding.viewModel = sharedViewModel

        // Initialize buttons
        binding.queryButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_queryFragment_to_saleInfoFragment)
        })

        // return inflater.inflate(R.layout.query_fragment, container, false)
        return binding.root
    }
}