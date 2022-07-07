package com.example.bookdiscover.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.bookdiscover.databinding.FragmentResultVolumeListBinding
import com.example.bookdiscover.network.Volume

class ResultVolumeListFragment : Fragment() {

    // QueryViewModel shared by other volume fragments and QueryActivity
    private val sharedViewModel: QueryViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Data-binding with XML
        val binding = FragmentResultVolumeListBinding.inflate(inflater)

        binding.apply {
            // QueryFragment determines the lifecycle of the binding.
            lifecycleOwner = viewLifecycleOwner
        }


        // TODO: wait for sharedViewModel to load!
//        val dataset = sharedViewModel.items.value!!

        val dataset = listOf(Volume("1"), Volume("2"), Volume("3"))
        val recyclerView = binding.recyclerView
        recyclerView.adapter = ResultVolumeListItemAdapter(dataset)
        recyclerView.setHasFixedSize(true)



        // Inflate the layout for this fragment
        return binding.root
    }


}