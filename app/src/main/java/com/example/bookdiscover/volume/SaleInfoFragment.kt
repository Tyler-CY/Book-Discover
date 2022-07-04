package com.example.bookdiscover.volume

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bookdiscover.databinding.FragmentSaleInfoBinding


class SaleInfoFragment : Fragment() {
    private val viewModel: SaleInfoViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentSaleInfoBinding.inflate(inflater)

        // SaleInfoFragment determines the lifecycle of the binding.
        binding.lifecycleOwner = this

        // Give the binding access to the SaleInfoViewModel class
        binding.viewModel = viewModel

//        return inflater.inflate(R.layout.query_fragment, container, false)
        return binding.root
    }
}