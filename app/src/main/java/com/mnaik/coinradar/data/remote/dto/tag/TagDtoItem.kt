package com.mnaik.coinradar.data.remote.dto.tag


import com.google.gson.annotations.SerializedName

data class TagDtoItem(
    val id: String,
    val name: String,
    @SerializedName("coin_counter")
    val coinCounter: Int,
    @SerializedName("ico_counter")
    val icoCounter: Int,
    val description: String,
    val type: String,
    val coins: List<String>,
    val icos: List<String>
)