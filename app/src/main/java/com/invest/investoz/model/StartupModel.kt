package com.invest.investoz.model

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.invest.investoz.R
import com.squareup.picasso.Picasso

data class StartupModel(
    val _id: String,
    val about: String,
    val evaluation: String,
    val logo: String,
    val minAmmount: String,
    val name: String,
    val percentageEquity : String,
    val goingUp : Boolean
)

@BindingAdapter("android:loadImage")
fun loadImage(image : AppCompatImageView, url: String) {
    if(url.isNotEmpty())
        Picasso.get().load(url).placeholder(R.drawable.startup_img).into(image)
}