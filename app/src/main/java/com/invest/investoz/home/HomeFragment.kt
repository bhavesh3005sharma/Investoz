package com.invest.investoz.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.invest.investoz.adapter.StartupTrendAdapter
import com.invest.investoz.databinding.FragmentHomeBinding
import com.invest.investoz.model.StartupModel

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val startupModel = StartupModel("88","erfva","efwaedf","fed","ewfds","Groww")
    private val list = mutableListOf(startupModel)
    private val adapter = StartupTrendAdapter(list)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

        for (i in 0..4) { list.add(startupModel) }
        binding.rvStartupsTrend.adapter = adapter

        return binding.root
    }

}