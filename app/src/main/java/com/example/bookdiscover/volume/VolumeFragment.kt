package com.example.bookdiscover.volume

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bookdiscover.R
import com.example.bookdiscover.databinding.FragmentVolumeBinding
import com.example.bookdiscover.result.ResultViewModel

/**
 * The fragment class which shows the result overview; used in ResultActivity
 */
class VolumeFragment : Fragment() {

    // QueryViewModel shared by other volume fragments and QueryActivity
    private val sharedViewModel: ResultViewModel by activityViewModels()
//    private val position = activity!!.intent.getIntExtra("POSITION", 0)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Data-binding with XML
        val binding = FragmentVolumeBinding.inflate(inflater)

        binding.apply {
            // QueryFragment determines the lifecycle of the binding.
            lifecycleOwner = viewLifecycleOwner

            // Give the binding access to the QueryViewModel class
            viewModel = sharedViewModel

            // Initialize buttons
            queryButton.setOnClickListener {
                findNavController().navigate(R.id.action_volumeFragment_to_saleInfoFragment)
            }

        }

//
//        sharedViewModel.items.observe(this) {
//
//            binding.volumeTitle.text = it.get(position).volumeInfo!!.get("title").toString()
//        }


        return binding.root
    }
}