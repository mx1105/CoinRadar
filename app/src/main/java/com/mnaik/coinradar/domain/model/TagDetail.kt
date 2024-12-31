package com.mnaik.coinradar.domain.model

/**
 * Created by Monil Naik on 31-12-2024.
 */
data class TagDetail(
    val id: String,
    val name: String,
    val coinCounter: Int,
    val icoCounter: Int,
    val description: String,
    val coins: List<String>,
    val icos: List<String>
)

fun String.toName(): String {
    return this
}