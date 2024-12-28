package com.mnaik.coinradar.presentation.coin_list

import com.mnaik.coinradar.domain.model.Coin

/**
 * Created by Monil Naik on 28-12-2024.
 */
data class CoinsListState(
    val isLoading: Boolean = false, val coins: List<Coin> = emptyList(), val error: String = ""
)
