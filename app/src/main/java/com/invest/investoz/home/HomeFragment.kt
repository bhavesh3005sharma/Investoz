package com.invest.investoz.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.invest.investoz.adapter.NewsAdapter
import com.invest.investoz.adapter.StartupAdapter
import com.invest.investoz.adapter.StartupTrendAdapter
import com.invest.investoz.databinding.FragmentHomeBinding
import com.invest.investoz.model.NewsModel
import com.invest.investoz.model.StartupModel

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val startupModel = StartupModel("88","Kylo Apps is a software company based out of Delhi, India, offering software development services to clients all over the world. \n","2.56L","https://ibb.co/KDCMjsJ","24.55","Kylo Apps","34.78%",false)
    private val startUpTrendList = mutableListOf(startupModel)
    private val startUpsList = mutableListOf(startupModel)
    private val newsList = mutableListOf(NewsModel("","","",),NewsModel("","","",),NewsModel("","","",),NewsModel("","","",))
    private val startupTrendAdapter = StartupTrendAdapter(startUpTrendList)
    private val startupAdapter = StartupAdapter(startUpsList)
    private val newsAdapter = NewsAdapter(newsList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

        for (i in 0..4) { startUpTrendList.add(startupModel) }
        startUpsList.addAll(startUpTrendList)
        binding.rvStartupsTrend.adapter = startupTrendAdapter
        binding.rvStartups.adapter = startupAdapter
        binding.rvNews.adapter = newsAdapter

        return binding.root
    }

}