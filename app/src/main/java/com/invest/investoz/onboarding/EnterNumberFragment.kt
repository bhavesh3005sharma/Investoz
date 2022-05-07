package com.invest.investoz.onboarding

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.invest.investoz.R
import com.invest.investoz.databinding.FragmentEnterNumberBinding
import java.util.concurrent.TimeUnit


class EnterNumberFragment : Fragment() {

    private lateinit var binding: FragmentEnterNumberBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var verificationId: String

    val viewModel: OnboardingActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterNumberBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance()

        binding.btnGetOTP.setOnClickListener {
            if(binding.textNumber.text.isNullOrEmpty()) {
                Toast.makeText(activity, "Please enter mobile number", Toast.LENGTH_SHORT).show()
            }else {
                val phone = "+91"+binding.textNumber.text.toString()
                sendVerificationCode(phone)
            }
        }

        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnVerifyOTP.setOnClickListener {
            if (TextUtils.isEmpty(binding.textOtp.getText().toString())) {
                Toast.makeText(activity, "Please enter OTP", Toast.LENGTH_SHORT).show();
            } else {
                verifyCode(binding.textOtp.getText().toString());
            }
        }
    }

    private fun sendVerificationCode(number: String) {
        // this method is used for getting
        // OTP on user phone number.
        val options: PhoneAuthOptions = PhoneAuthOptions.newBuilder(mAuth)
            .setPhoneNumber(number) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(requireActivity()) // Activity (for callback binding)
            .setCallbacks(mCallBack) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private val mCallBack: OnVerificationStateChangedCallbacks =
        object : OnVerificationStateChangedCallbacks() {
            override fun onCodeSent(s: String, forceResendingToken: ForceResendingToken) {
                super.onCodeSent(s, forceResendingToken)

                Toast.makeText(activity, "OTP Sent!", Toast.LENGTH_SHORT).show()
                verificationId = s
            }

            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                val code = phoneAuthCredential.smsCode

                if (code != null) {
                    binding.textOtp.setText(code)

                    verifyCode(code)
                }
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(activity, e.message, Toast.LENGTH_LONG).show()
            }
        }

    private fun verifyCode(code: String) {
        val credential = PhoneAuthProvider.getCredential(verificationId, code)

        signInWithCredential(credential)
    }

    private fun signInWithCredential(credential: PhoneAuthCredential) {
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    viewModel.detail.value?.contact = binding.textNumber.text.toString()
                    findNavController().navigate(R.id.action_enterNumberFragment_to_enterEmailPasswordFragment)
                } else {
                    Toast.makeText(
                        activity,
                        task.exception.toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }
    companion object {
       @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EnterNumberFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}