package com.invest.investoz.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.invest.investoz.R
import com.invest.investoz.databinding.FragmentAboutUsBinding
import com.invest.investoz.databinding.FragmentHomeBinding

class AboutUsFragment : Fragment() {

    private lateinit var binding : FragmentAboutUsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutUsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

}