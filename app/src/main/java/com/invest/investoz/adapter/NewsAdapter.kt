package com.invest.investoz.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invest.investoz.databinding.LayoutNewsBinding
import com.invest.investoz.databinding.LayoutStartupHomeBinding
import com.invest.investoz.databinding.LayoutTrendHeadingBinding
import com.invest.investoz.databinding.LayoutTrendStartupBinding
import com.invest.investoz.model.NewsModel
import com.invest.investoz.model.StartupModel

class NewsAdapter(
    private val list : List<NewsModel>
)  : RecyclerView.Adapter<NewsAdapter.LayoutNewsViewHolder>() {

    class LayoutNewsViewHolder(private val binding: LayoutNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(newsModel : NewsModel) : LayoutNewsBinding {
            binding.news = newsModel
            return binding
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LayoutNewsViewHolder {
        val binding: LayoutNewsBinding = LayoutNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LayoutNewsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: LayoutNewsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}