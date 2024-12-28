package com.mnaik.coinradar.domain.repository

import com.mnaik.coinradar.data.remote.dto.CoinDetailDto
import com.mnaik.coinradar.data.remote.dto.CoinDto

/**
 * Created by Monil Naik on 27-12-2024.
 */
interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}