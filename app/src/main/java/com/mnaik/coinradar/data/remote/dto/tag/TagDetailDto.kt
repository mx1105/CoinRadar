package com.mnaik.coinradar.data.remote.dto.tag


import com.google.gson.annotations.SerializedName
import com.mnaik.coinradar.domain.model.TagDetail

data class TagDetailDto(
    val id: String,
    val name: String,
    @SerializedName("coin_counter") val coinCounter: Int,
    @SerializedName("ico_counter") val icoCounter: Int,
    val description: String,
    val type: String,
    val coins: List<String>? = emptyList(),
    val icos: List<String>? = emptyList()
)


fun TagDetailDto.toTagDetail(): TagDetail {
    return TagDetail(
        id = id,
        name = name,
        coinCounter = coinCounter,
        icoCounter = icoCounter,
        description = description,
        coins = coins?: emptyList(),
        icos = icos?: emptyList()
    )
}