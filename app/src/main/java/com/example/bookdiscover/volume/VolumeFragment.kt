package com.example.bookdiscover.volume

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bookdiscover.R
import com.example.bookdiscover.databinding.FragmentVolumeBinding

/**
 * The fragment class which shows the result overview; used in ResultActivity
 */
class VolumeFragment : Fragment() {

    private val volumeViewModel: VolumeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Data-binding with XML
        val binding = FragmentVolumeBinding.inflate(inflater)

        binding.apply {
            // Set the lifecycleOwner
            lifecycleOwner = viewLifecycleOwner

            // Initialize buttons
            queryButton.setOnClickListener {
                findNavController().navigate(R.id.action_volumeFragment_to_saleInfoFragment)
            }
        }

        // TODO: For now, set the text as the title
        volumeViewModel.volumeInfo.observe(viewLifecycleOwner) {
            binding.volumeTitle.text = it!!.get("title").toString()
        }

        return binding.root
    }
}