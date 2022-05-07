package com.invest.investoz.model

import android.net.Uri
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.SerializedName

@Keep
@Parcelize
data class User(
    @SerializedName("fullName")
    var fullName: String? = null,

    @SerializedName("panNumber")
    var panNumber: String? = null,

    @SerializedName("sex")
    var sex: String? = null,

    @SerializedName("dob")
    var dob: String? = null,

    @SerializedName("email")
    var email: String? = null,

    @SerializedName("incomeRange")
    var incomeRange: String? = null,

    @SerializedName("profession")
    var profession: String? = null,

    @SerializedName("photoURI")
    var photoUri: Uri? = null,

    @SerializedName("contact")
    var contact: String? = null

) : Parcelable
