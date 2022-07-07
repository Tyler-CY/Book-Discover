package com.example.bookdiscover.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.bookdiscover.databinding.FragmentResultBinding
import com.example.bookdiscover.network.Volume

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


        sharedViewModel.items.observe(this, Observer<List<Volume>>{
            val dataset = sharedViewModel.items.value!!

//        val dataset = listOf(Volume("1"), Volume("2"), Volume("3"),Volume("4"),Volume("5"),
//            Volume("6"),Volume("7"),Volume("8"),Volume("9"),Volume("0"), Volume("A1"), Volume("A2"), Volume("A3"),Volume("A4"),Volume("A5"),
//            Volume("A6"),Volume("A7"),Volume("A8"),Volume("A9"),Volume("A0"))

            val recyclerView = binding.recyclerView
            recyclerView.adapter = ResultAdapter(dataset)
            recyclerView.setHasFixedSize(true)
        })






        // Inflate the layout for this fragment
        return binding.root
    }


}