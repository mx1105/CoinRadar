package com.mnaik.coinradar.presentation.coin_detail

import com.mnaik.coinradar.domain.model.CoinDetail

/**
 * Created by Monil Naik on 28-12-2024.
 */
data class CoinDetailState(
    val isLoading: Boolean = false, val coin: CoinDetail? = null, val error: String = ""
)