package com.mnaik.coinradar.di

import com.mnaik.coinradar.common.Constants
import com.mnaik.coinradar.data.remote.CoinApi
import com.mnaik.coinradar.data.repository.CoinRepositoryImpl
import com.mnaik.coinradar.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Monil Naik on 27-12-2024.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): CoinApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(CoinApi::class.java)
    }


    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

}