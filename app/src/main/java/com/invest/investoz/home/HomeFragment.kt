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
    private val startUpTrendList = mutableListOf(
        StartupModel("","Kylo Apps is a software company based out of Delhi, India, offering software development services to clients all over the world.",
                "24.5L",
                "https://ibb.co/KDCMjsJ",
                    "22.55",
            "Kylo Apps",
            "22.67%",
            true
        ),
        StartupModel("","Campk12 is a software company based out of Delhi, India, offering software development services to clients all over the world.",
            "24.5L",
            "https://ibb.co/m66hDb3",
            "22.55",
            "Campk12",
            "56.67%",
            true
        ),
        StartupModel("","Catfat India is a software company based out of Delhi, India, offering software development services to clients all over the world.",
            "24.5L",
            "https://ibb.co/KDCMjsJ",
            "22.55",
            "Catfat India",
            "22.67%",
            true
        ),
        StartupModel("","Pixis is a software company based out of Delhi, India, offering software development services to clients all over the world.",
            "24.5L",
            "https://ibb.co/KDCMjsJ",
            "22.55",
            "Pixis",
            "22.67%",
            true
        )
    )
    private val startUpsList = mutableListOf(
        StartupModel("","Kylo Apps is a software company based out of Delhi, India, offering software development services to clients all over the world.",
            "24.5L",
            "https://ibb.co/KDCMjsJ",
            "22.55",
            "Kylo Apps",
            "22.67%",
            true
        ),
        StartupModel("","Campk12 is a software company based out of Delhi, India, offering software development services to clients all over the world.",
            "24.5L",
            "https://ibb.co/m66hDb3",
            "22.55",
            "Campk12",
            "56.67%",
            true
        ),
        StartupModel("","Catfat India is a software company based out of Delhi, India, offering software development services to clients all over the world.",
            "24.5L",
            "https://ibb.co/KDCMjsJ",
            "22.55",
            "Catfat India",
            "22.67%",
            true
        ),
        StartupModel("","Pixis is a software company based out of Delhi, India, offering software development services to clients all over the world.",
            "24.5L",
            "https://ibb.co/KDCMjsJ",
            "22.55",
            "Pixis",
            "22.67%",
            true
        )
    )
    private val newsList = mutableListOf(NewsModel("","","",),NewsModel("","","",),NewsModel("","","",),NewsModel("","","",))
    private val startupTrendAdapter = StartupTrendAdapter(startUpTrendList)
    private val startupAdapter = StartupAdapter(startUpsList)
    private val newsAdapter = NewsAdapter(newsList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

        binding.rvStartupsTrend.adapter = startupTrendAdapter
        binding.rvStartups.adapter = startupAdapter
        binding.rvNews.adapter = newsAdapter

        return binding.root
    }

}