package com.mnaik.coinradar.data.remote

import com.mnaik.coinradar.data.remote.dto.coin.CoinDetailDto
import com.mnaik.coinradar.data.remote.dto.coin.CoinDto
import com.mnaik.coinradar.data.remote.dto.tag.TagDetailDto
import com.mnaik.coinradar.data.remote.dto.tag.TagDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Monil Naik on 27-12-2024.
 */
interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto


    @GET("/v1/tags")
    suspend fun getTags(): List<TagDto>

    @GET("/v1/tags/{tagId}")
    suspend fun getTagById(@Path("tagId") coinId: String, @Query("additional_fields") additionalParams: String): TagDetailDto
}