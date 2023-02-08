package com.example.weak4day2.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.weak4day2.R

import com.example.weak4day2.databinding.FragmentSettingBinding


class SettingFragment : Fragment(R.layout.fragment_setting) {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSettingBinding.bind(view)

        val pref = MySharedPref(requireContext())

        binding.button.setOnClickListener {
            pref.saveFont(20f)
        }
        binding.button2.setOnClickListener {
            pref.saveFont(30f)
        }
        binding.button3.setOnClickListener {
            pref.saveFont(40f)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}