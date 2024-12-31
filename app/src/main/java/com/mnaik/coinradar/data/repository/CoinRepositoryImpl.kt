package com.mnaik.coinradar.data.repository

import com.mnaik.coinradar.data.remote.CoinApi
import com.mnaik.coinradar.data.remote.dto.coin.CoinDetailDto
import com.mnaik.coinradar.data.remote.dto.coin.CoinDto
import com.mnaik.coinradar.domain.repository.CoinRepository
import javax.inject.Inject

/**
 * Created by Monil Naik on 27-12-2024.
 */
class CoinRepositoryImpl @Inject constructor(private val api: CoinApi) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}