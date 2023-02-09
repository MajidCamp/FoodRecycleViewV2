package com.example.weak4day2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.weak4day2.viewmodel.FoodViewModel
import com.example.weak4day2.ui.settings.MySharedPref
import com.example.weak4day2.R
import com.example.weak4day2.databinding.FragmentFoodBinding

class FoodFragment : Fragment(R.layout.fragment_food) {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<FoodViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodBinding.bind(view)


        val adapter = FoodsAdapter(MySharedPref(requireContext())) {
            val action =
                FoodFragmentDirections.actionFoodFragmentToFoodDetailsFragment(it.name, it.imageUrl)
            view.findNavController().navigate(action)
        }
        binding.tvFoods.adapter = adapter
        viewModel.foodList.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }


        binding.apply {
            binding.ADD.setOnClickListener {
                viewModel.add()
                adapter.notifyItemInserted(1)
            }
            binding.Remove.setOnClickListener {
                viewModel.remove()
                adapter.notifyItemRemoved(1)
            }
//            //Remove By Index
            binding.positionButton.setOnClickListener {
                val x = binding.positionText.text.toString().toInt()
                viewModel.removeIndex(x)
                adapter.notifyItemRemoved(x)
            }
        }
    }
        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }


    }
