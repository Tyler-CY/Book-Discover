package com.example.bookdiscover.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bookdiscover.SEARCH_NAME
import com.example.bookdiscover.databinding.FragmentSearchFilterBinding
import com.example.bookdiscover.result.ResultActivity

class SearchFilterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Data-binding with XML
        val binding = FragmentSearchFilterBinding.inflate(inflater)

        binding.apply{
            // QueryFragment determines the lifecycle of the binding.
            lifecycleOwner = viewLifecycleOwner

            // Initialize buttons
            submitButton.setOnClickListener {
                val intent = Intent(activity, ResultActivity::class.java)
                val name = nameText.text.toString()
                intent.putExtra(SEARCH_NAME, name)
                startActivity(intent)
            }
        }


        return binding.root
    }
}