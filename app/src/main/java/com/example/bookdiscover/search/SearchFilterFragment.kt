package com.example.bookdiscover.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bookdiscover.MainActivity
import com.example.bookdiscover.R
import com.example.bookdiscover.databinding.FragmentSaleInfoBinding
import com.example.bookdiscover.databinding.FragmentSearchFilterBinding

private const val TAG = "SearchFilterFragment"
class SearchFilterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchFilterBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        binding.submitButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            Log.d(TAG, "Launch Intent")
            startActivity(intent)
        })


        return binding.root
    }

}