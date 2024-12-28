package com.mnaik.coinradar.domain.model

/**
 * Created by Monil Naik on 27-12-2024.
 */
data class Coin(
    val id: String, val name: String, val symbol: String, val rank: Int, val isActive: Boolean
)