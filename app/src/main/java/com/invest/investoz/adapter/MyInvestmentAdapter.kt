package com.invest.investoz.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invest.investoz.R
import com.invest.investoz.databinding.ItemMyInvestmentBinding
import com.invest.investoz.databinding.ItemPendingInvestmentBinding
import com.invest.investoz.model.MyInvestment
import com.invest.investoz.model.PendingInvestment

class MyInvestmentAdapter(
    private val list : List<MyInvestment>,
    val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class LayoutViewHolder(private val binding: ItemMyInvestmentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myInvestment: MyInvestment, position: Int, context: Context) : ItemMyInvestmentBinding {
            if(position==1) binding.circleImageView2.setImageDrawable(context.getDrawable(R.drawable.sample_investment_logo2))
            if(position==2) binding.circleImageView2.setImageDrawable(context.getDrawable(R.drawable.sample_investment_logo3))
            binding.myInvestment = myInvestment
            return binding
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val binding: ItemMyInvestmentBinding = ItemMyInvestmentBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return LayoutViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        ( holder as LayoutViewHolder ).bind(list[position], position, context)
    }

    override fun getItemCount() = list.size
}