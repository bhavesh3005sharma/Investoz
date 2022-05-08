package com.invest.investoz.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.invest.investoz.R
import com.invest.investoz.adapter.PendingAdapter
import com.invest.investoz.adapter.StartupTrendAdapter
import com.invest.investoz.databinding.FragmentInvestmentsBinding
import com.invest.investoz.databinding.FragmentPendingInvestmentBinding
import com.invest.investoz.model.PendingInvestment
import com.invest.investoz.model.StartupModel

class PendingInvestmentFragment : Fragment() {

    private lateinit var binding : FragmentPendingInvestmentBinding
    private val model = PendingInvestment("Kylo Apps is a software company based out of Delhi, India, offering software development services to clients all over the world. \n",
    "5%",
    "",
    "50K",
    "Kylo Apps")

    private val list = mutableListOf(model,
        PendingInvestment("We worked with schools and companies like Google and Adobe to bring hands-on coding bootcamps to students .\n",
            "5%",
            "",
            "50K",
            "Campk12"),
        PendingInvestment("We build incredibly advanced codeless AI infrastructure to help brands grow exponentially. Strengthened with over 4 dozen  contextual and self-evolving proprietary AI models, the infrastructure forms the very heart of our products.",
            "5%",
            "",
            "60K",
            "Pixis"),
        PendingInvestment("Catfatindia is\n" +
                "Distinctive fashion for the contemporary Indian\n" +
                "with In-house capabilities in design.\n",
            "5%",
            "",
            "50K",
            "Catfatindia")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPendingInvestmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PendingAdapter(list, requireActivity())
        binding.rvStartupsTrend.adapter = adapter
    }

}