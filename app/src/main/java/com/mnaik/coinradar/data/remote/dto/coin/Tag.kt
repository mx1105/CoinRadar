package com.mnaik.coinradar.data.remote.dto.coin


import com.google.gson.annotations.SerializedName

data class Tag(
    val id: String,
    val name: String,
    @SerializedName("coin_counter") val coinCounter: Int,
    @SerializedName("ico_counter") val icoCounter: Int
){
    override fun toString(): String {
        return name
    }
}

