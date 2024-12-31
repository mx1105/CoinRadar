package com.mnaik.coinradar.domain.use_case.get_coin

import com.mnaik.coinradar.common.Resource
import com.mnaik.coinradar.data.remote.dto.coin.toCoinDetail
import com.mnaik.coinradar.domain.model.CoinDetail
import com.mnaik.coinradar.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Monil Naik on 27-12-2024.
 */
class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An Unexpected Error occurs"))
        } catch (e: IOException) {
            emit(Resource.Error("Please Check Your internet connection"))
        }
    }
}