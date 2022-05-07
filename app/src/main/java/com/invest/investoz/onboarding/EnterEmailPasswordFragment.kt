package com.invest.investoz.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.common.internal.Objects
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.invest.investoz.MainActivity
import com.invest.investoz.R
import com.invest.investoz.databinding.FragmentEnterEmailPasswordBinding
import com.invest.investoz.databinding.FragmentEnterNumberBinding

class EnterEmailPasswordFragment : Fragment() {

    private lateinit var binding: FragmentEnterEmailPasswordBinding
    var mAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnterEmailPasswordBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            if(binding.textEmail.text.isNullOrEmpty() ||
                    binding.textPassword.text.isNullOrEmpty() ||
                    binding.textUsername.text.isNullOrEmpty()) {
                Toast.makeText((activity), "Please enter all the fields!", Toast.LENGTH_SHORT)
            }else {
                mAuth.createUserWithEmailAndPassword(binding.textEmail.text.toString(), binding.textPassword.text.toString()).addOnCompleteListener(requireActivity(), OnCompleteListener { task ->
                    if (task.isSuccessful) {
                        requireActivity().run {
                            startActivity(Intent(this, MainActivity::class.java))
                        }
                        activity?.finish()
                    }else {
                        Toast.makeText(activity, "Error registering, try again later :(", Toast.LENGTH_LONG).show()
                    }
                })
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EnterEmailPasswordFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}