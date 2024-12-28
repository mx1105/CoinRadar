package com.mnaik.coinradar.data.remote

import com.mnaik.coinradar.data.remote.dto.CoinDetailDto
import com.mnaik.coinradar.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Monil Naik on 27-12-2024.
 */
interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}