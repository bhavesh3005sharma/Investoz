package com.invest.investoz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invest.investoz.databinding.LayoutStartupHomeBinding
import com.invest.investoz.databinding.LayoutTrendHeadingBinding
import com.invest.investoz.databinding.LayoutTrendStartupBinding
import com.invest.investoz.model.StartupModel

class StartupAdapter(
    private val list : List<StartupModel>
)  : RecyclerView.Adapter<StartupAdapter.LayoutStartupViewHolder>() {

    class LayoutStartupViewHolder(private val binding: LayoutStartupHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(startupModel: StartupModel) : LayoutStartupHomeBinding {
            binding.startup = startupModel
            return binding
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LayoutStartupViewHolder {
        val binding: LayoutStartupHomeBinding = LayoutStartupHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LayoutStartupViewHolder(binding)

    }

    override fun onBindViewHolder(holder: LayoutStartupViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}