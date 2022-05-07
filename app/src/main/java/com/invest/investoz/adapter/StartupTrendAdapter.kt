package com.invest.investoz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invest.investoz.databinding.LayoutTrendHeadingBinding
import com.invest.investoz.databinding.LayoutTrendStartupBinding
import com.invest.investoz.model.StartupModel

class StartupTrendAdapter(
    private val list : List<StartupModel>
)  : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class TrendHeadingViewHolder(binding: LayoutTrendHeadingBinding) : RecyclerView.ViewHolder(binding.root)

    class LayoutTrendStartupViewHolder(private val binding: LayoutTrendStartupBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(startupModel: StartupModel) : LayoutTrendStartupBinding {
            binding.startup = startupModel
            return binding
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        if(viewType==0) {
            val binding: LayoutTrendHeadingBinding = LayoutTrendHeadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return TrendHeadingViewHolder(binding)
        }
        val binding: LayoutTrendStartupBinding = LayoutTrendStartupBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LayoutTrendStartupViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position!=0){
            ( holder as LayoutTrendStartupViewHolder ).bind(list[position])
        }
    }

    override fun getItemCount() = list.size

}