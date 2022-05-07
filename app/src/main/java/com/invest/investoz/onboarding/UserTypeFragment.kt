package com.invest.investoz.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.invest.investoz.R
import com.invest.investoz.databinding.FragmentUserTypeBinding

class UserTypeFragment : Fragment() {


    private lateinit var binding: FragmentUserTypeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserTypeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonGrabInvestment.setOnClickListener {

            findNavController().navigate(R.id.action_userTypeFragment_to_loginFragment)
        }
        binding.buttonWantToInvest.setOnClickListener {

            findNavController().navigate(R.id.action_userTypeFragment_to_loginFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserTypeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}