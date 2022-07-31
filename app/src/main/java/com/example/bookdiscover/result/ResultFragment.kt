package com.example.bookdiscover.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import com.example.bookdiscover.databinding.FragmentResultBinding

/**
 * The main fragment used in ResultActivity
 */
class ResultFragment : Fragment() {

    // ResultViewModel shared by other volume fragments and ResultActivity
    private val sharedViewModel: ResultViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Data-binding with XML
        val binding = FragmentResultBinding.inflate(inflater)

        binding.apply {
            // ResultViewModel determines the lifecycle of the binding.
            lifecycleOwner = viewLifecycleOwner

            viewModel = sharedViewModel
        }


        sharedViewModel.items.observe(this) {
            val dataset = sharedViewModel.items.value!!

            if (dataset.isNotEmpty()){
                binding.resultLayout.removeViewAt(0)
                val recyclerView = binding.recyclerView
                binding.recyclerView.isVisible = true
                recyclerView.adapter = ResultAdapter(this@ResultFragment.activity!!, dataset)
                recyclerView.setHasFixedSize(true)
            }

            else {
                binding.recyclerView.isVisible = false

                val textView = TextView(activity!!)
                textView.id = View.generateViewId()
                textView.text = "Loading..."
                textView.textSize = 24F
                binding.resultLayout.addView(textView, 0)

                // Sets the textView to the middle by using ConstraintSet
                val constraintSet = ConstraintSet()
                constraintSet.clone(binding.resultLayout)
                constraintSet.connect(textView.id, ConstraintSet.TOP, binding.resultLayout.id, ConstraintSet.TOP)
                constraintSet.connect(textView.id, ConstraintSet.START, binding.resultLayout.id, ConstraintSet.START)
                constraintSet.connect(textView.id, ConstraintSet.END, binding.resultLayout.id, ConstraintSet.END)
                constraintSet.connect(textView.id, ConstraintSet.BOTTOM, binding.resultLayout.id, ConstraintSet.BOTTOM)
                constraintSet.applyTo(binding.resultLayout)
            }
        }


        // Inflate the layout for this fragment
        return binding.root
    }


}