package com.pabloSanjuan.listadoproductos.data.models


import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
class Seller(
    @SerializedName("eshop")
    val eshop: Eshop? = Eshop(),
) : Parcelable