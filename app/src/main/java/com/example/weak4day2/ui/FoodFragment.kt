package com.example.weak4day2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
//import com.example.weak4day2.FoodFragmentDirections
import com.example.weak4day2.viewmodel.FoodViewModel
import com.example.weak4day2.ui.settings.MySharedPref
import com.example.weak4day2.R
import com.example.weak4day2.databinding.FragmentFoodBinding
import com.example.weak4day2.model.FoodInterfaceImpl

class FoodFragment : Fragment(R.layout.fragment_food) {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<FoodViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFoodBinding.bind(view)


//        val strings = listOf("foodADD1","foodADD2","foodADD3","foodADD4")
//        val namesList = mutableListOf(
//
//            Foods("Food1",R.drawable.baseline_fastfood_24),
//            Foods("Food2",R.drawable.baseline_emoji_food_beverage_24),
//            Foods("Food3",R.drawable.baseline_fastfood_24),
//            Foods("Food4",R.drawable.baseline_emoji_food_beverage_24),
//            Foods("Food5",R.drawable.baseline_fastfood_24),
//            Foods("Food6",R.drawable.baseline_emoji_food_beverage_24),
//            Foods("Food7",R.drawable.baseline_fastfood_24),
//            Foods("Food8",R.drawable.baseline_emoji_food_beverage_24),
//            Foods("Food9",R.drawable.baseline_fastfood_24),
//
//        )
        val adapter = FoodsAdapter(MySharedPref(requireContext())) {
            val action =
                FoodFragmentDirections.actionFoodFragmentToFoodDetailsFragment(it.name, it.imageUrl)
            view.findNavController().navigate(action)
        }
        binding.tvFoods.adapter = adapter
        viewModel.foodList.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            adapter.notifyDataSetChanged()
        }


        //ADD function doesn`t work correctly
        var add = FoodInterfaceImpl()
        binding.apply {
            binding.ADD.setOnClickListener {
                add.addItem()
                adapter.notifyItemInserted(1)
            }
            binding.Remove.setOnClickListener {
                add.removeItem()
                adapter.notifyItemRemoved(1)
            }
//            //Remove By Index
//            binding.positionButton.setOnClickListener {
//                val x = binding.positionText.text.toString()
//                namesList.removeAt(x.toInt())
//                adapter.notifyItemRemoved(x.toInt())
//            } 


        }


    }
        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }


    }
