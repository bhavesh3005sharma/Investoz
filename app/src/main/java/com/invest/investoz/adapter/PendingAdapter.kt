package com.invest.investoz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invest.investoz.R
import com.invest.investoz.databinding.ItemPendingInvestmentBinding
import com.invest.investoz.model.PendingInvestment

class PendingAdapter(
    private val list : List<PendingInvestment>,
    val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    class LayoutViewHolder(private val binding: ItemPendingInvestmentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pendingInvestment: PendingInvestment, position: Int, context: Context) : ItemPendingInvestmentBinding {
            if(position==1) {
                binding.circleImageView2.setImageDrawable(context.getDrawable(R.drawable.sample_investment_logo2))
                binding.status.text = "Sent"
            }
            if(position==2) {
                binding.circleImageView2.setImageDrawable(context.getDrawable(R.drawable.sample_investment_logo3))
                binding.status.text = "Documented"
            }
            if(position==3) {
                binding.circleImageView2.setImageDrawable(context.getDrawable(R.drawable.sample_investment_logo4))
            }
            binding.pendingInvestment = pendingInvestment
            return binding
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val binding: ItemPendingInvestmentBinding = ItemPendingInvestmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LayoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        ( holder as LayoutViewHolder ).bind(list[position], position, context)
    }

    override fun getItemCount() = list.size
}