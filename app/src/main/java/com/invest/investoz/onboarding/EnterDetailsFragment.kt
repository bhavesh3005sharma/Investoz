package com.invest.investoz.onboarding

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.invest.investoz.R
import com.invest.investoz.databinding.FragmentEnterDetailsBinding
import java.text.SimpleDateFormat
import java.util.*


class EnterDetailsFragment : Fragment() {

    private lateinit var binding: FragmentEnterDetailsBinding

    val viewModel: OnboardingActivityViewModel by activityViewModels()

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

        var cal = Calendar.getInstance()
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                val myFormat = "MM/dd/yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                binding.dob.setText(sdf.format(cal.getTime()))
            }
        }
        binding.dob.setOnClickListener {
            DatePickerDialog(requireActivity(),
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }
        val timingArray = resources.getStringArray(R.array.sex)
        val sexAdapter = ArrayAdapter(activity as Context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, timingArray)
        binding.sex.setAdapter(sexAdapter)


        val incomeArray = resources.getStringArray(R.array.income)
        val incomeAdapter = ArrayAdapter(activity as Context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, incomeArray)
        binding.income.setAdapter(incomeAdapter)


        val professionArray = resources.getStringArray(R.array.profession)
        val professionAdapter = ArrayAdapter(activity as Context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, professionArray)
        binding.profession.setAdapter(professionAdapter)

        binding.btnContinue.setOnClickListener {
            if(binding.fullName.text.isNullOrEmpty() ||
                    binding.panNumber.text.isNullOrEmpty() ||
                    binding.sex.text.isNullOrEmpty() ||
                    binding.dob.text.isNullOrEmpty() ||
                    binding.income.text.isNullOrEmpty() ||
                    binding.profession.text.isNullOrEmpty()) {
                Toast.makeText((activity), "Please enter all the fields!", Toast.LENGTH_SHORT).show()
            }else {
                viewModel.detail.value?.fullName = binding.fullName.text.toString()
                viewModel.detail.value?.panNumber = binding.panNumber.text.toString()
                viewModel.detail.value?.sex = binding.sex.text.toString()
                viewModel.detail.value?.dob = binding.dob.text.toString()
                viewModel.detail.value?.incomeRange = binding.income.text.toString()
                viewModel.detail.value?.profession = binding.profession.text.toString()
                findNavController().navigate(R.id.action_enterDetailsFragment_to_enterNumberFragment)
            }
        }

        binding.circleImageView.setOnClickListener {
            val i = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(
                Intent.createChooser(i, "Select Picture"), 0
            )
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
            val uri: Uri? = data.data
            binding.circleImageView.setImageURI(uri)
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