package com.example.weak4day2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import coil.load
//import com.example.weak4day2.FoodDetailsFragmentArgs
import com.example.weak4day2.R
import com.example.weak4day2.databinding.FragmentFoodDetailsBinding


class FoodDetailsFragment : Fragment(R.layout.fragment_food_details) {
    private var _binding: FragmentFoodDetailsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<FoodDetailsFragmentArgs>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodDetailsBinding.bind(view)
       // Toast.makeText(requireContext(),"Hello",Toast.LENGTH_SHORT).show()
        binding.title.text = args.name
        binding.image.load(args.imageUrl)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}