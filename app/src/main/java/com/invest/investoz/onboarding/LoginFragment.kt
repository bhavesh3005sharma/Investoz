package com.invest.investoz.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.invest.investoz.MainActivity
import com.invest.investoz.R
import com.invest.investoz.databinding.FragmentLoginBinding
import com.invest.investoz.databinding.FragmentUserTypeBinding

class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding

    var mAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnSignIn.setOnClickListener {
            if(binding.textEmail.text.isNullOrEmpty() ||
                binding.textPassword.text.isNullOrEmpty()){
                Toast.makeText((activity), "Please enter all the fields!", Toast.LENGTH_SHORT).show()
            }else {
                mAuth.signInWithEmailAndPassword(binding.textEmail.text.toString(), binding.textPassword.text.toString()).addOnCompleteListener ( requireActivity(), OnCompleteListener<AuthResult> { task ->
                    if (task.isSuccessful) {
                        requireActivity().run {
                            startActivity(Intent(this, MainActivity::class.java))
                        }
                        Toast.makeText(activity, "Successfully Logged in :)", Toast.LENGTH_LONG).show()
                        activity?.finish()
                    } else {
                        Toast.makeText(activity, "Error Logging in :(", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_enterDetailsFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}