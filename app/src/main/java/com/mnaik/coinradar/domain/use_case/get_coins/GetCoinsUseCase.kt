package com.mnaik.coinradar.domain.use_case.get_coins

import com.mnaik.coinradar.common.Resource
import com.mnaik.coinradar.data.remote.dto.coin.toCoin
import com.mnaik.coinradar.domain.model.Coin
import com.mnaik.coinradar.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by Monil Naik on 27-12-2024.
 */
class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An Unexpected Error occurs"))
        } catch (e: IOException) {
            emit(Resource.Error("Please Check Your internet connection"))
        }
    }
}