package com.invest.investoz.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import com.invest.investoz.R
import com.invest.investoz.databinding.FragmentEnterDetailsBinding
import com.invest.investoz.databinding.FragmentUserTypeBinding
import java.util.*

class EnterDetailsFragment : Fragment() {

    private lateinit var binding: FragmentEnterDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textDobLayout.setOnClickListener {
            //initDatePicker()
        }
        val timingArray = resources.getStringArray(R.array.sex)
        val arrayAdapter = ArrayAdapter(activity as Context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, timingArray)
        binding.sex.setAdapter(arrayAdapter)

        binding.btnContinue.setOnClickListener {
            findNavController().navigate(R.id.action_enterDetailsFragment_to_enterNumberFragment)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EnterDetailsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}