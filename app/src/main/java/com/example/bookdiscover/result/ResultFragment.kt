package com.example.bookdiscover.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bookdiscover.R
import com.example.bookdiscover.databinding.FragmentResultBinding

/**
 * The fragment class which shows the result overview; used in ResultActivity
 */
class ResultFragment : Fragment() {

    // QueryViewModel shared by other volume fragments and QueryActivity
    private val sharedViewModel: QueryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Data-binding with XML
        val binding = FragmentResultBinding.inflate(inflater)

        binding.apply {
            // QueryFragment determines the lifecycle of the binding.
            lifecycleOwner = viewLifecycleOwner

            // Give the binding access to the QueryViewModel class
            viewModel = sharedViewModel

            // Initialize buttons
            queryButton.setOnClickListener {
                findNavController().navigate(R.id.action_queryFragment_to_saleInfoFragment)
            }
        }

        return binding.root
    }
}