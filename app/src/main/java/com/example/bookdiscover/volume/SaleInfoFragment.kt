package com.example.bookdiscover.volume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bookdiscover.R
import com.example.bookdiscover.databinding.FragmentVolumeSaleInfoBinding

/**
 * The fragment class which shows only the sales info of a particular book.
 */
class SaleInfoFragment : Fragment() {

    private val volumeViewModel: VolumeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Data-binding with XML
        val binding = FragmentVolumeSaleInfoBinding.inflate(inflater)

        binding.apply {
            // QueryFragment determines the lifecycle of the binding.
            lifecycleOwner = viewLifecycleOwner

            // Give the binding access to the QueryViewModel class
//            viewModel = sharedViewModel

            // Initialize buttons
            saleButton.setOnClickListener {
                findNavController().navigate(R.id.action_saleInfoFragment_to_volumeFragment)
            }
        }


        volumeViewModel.saleInfo.observe(viewLifecycleOwner) {
            binding.volumeSale.text = it!!["country"].toString()
        }

        return binding.root
    }
}