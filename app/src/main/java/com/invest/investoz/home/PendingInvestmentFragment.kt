package com.invest.investoz.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.invest.investoz.R
import com.invest.investoz.databinding.FragmentInvestmentsBinding
import com.invest.investoz.databinding.FragmentPendingInvestmentBinding

class PendingInvestmentFragment : Fragment() {

    private lateinit var binding : FragmentPendingInvestmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPendingInvestmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

}