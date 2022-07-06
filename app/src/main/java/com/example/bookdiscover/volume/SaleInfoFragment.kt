package com.example.bookdiscover.volume

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.bookdiscover.R
import com.example.bookdiscover.databinding.FragmentSaleInfoBinding
import com.example.bookdiscover.query.QueryViewModel


class SaleInfoFragment : Fragment() {
    private val viewModel: QueryViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentSaleInfoBinding.inflate(inflater)

        // SaleInfoFragment determines the lifecycle of the binding.
        binding.lifecycleOwner = viewLifecycleOwner

        // Give the binding access to the SaleInfoViewModel class
        binding.viewModel = viewModel

        // Initialize buttons
        binding.saleButton.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_saleInfoFragment_to_queryFragment)
        })

        /**
         * or,
         * binding?.apply {
         *      // saleButton.setOnClickListener ......
         *      // viewModel = ...
         * }
         */

//        return inflater.inflate(R.layout.query_fragment, container, false)
        return binding.root
    }
}