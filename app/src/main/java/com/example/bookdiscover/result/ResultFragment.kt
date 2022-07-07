package com.example.bookdiscover.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.bookdiscover.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    // QueryViewModel shared by other volume fragments and QueryActivity
    private val sharedViewModel: ResultViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Data-binding with XML
        val binding = FragmentResultBinding.inflate(inflater)

        binding.apply {
            // QueryFragment determines the lifecycle of the binding.
            lifecycleOwner = viewLifecycleOwner

            viewModel = sharedViewModel
        }


        sharedViewModel.items.observe(this) {
            val dataset = sharedViewModel.items.value!!

            val recyclerView = binding.recyclerView
            recyclerView.adapter = ResultAdapter(this@ResultFragment.activity!!, dataset)
            recyclerView.setHasFixedSize(true)
        }


        // Inflate the layout for this fragment
        return binding.root
    }


}