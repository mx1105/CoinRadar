package com.mnaik.coinradar.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnaik.coinradar.common.Resource
import com.mnaik.coinradar.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Monil Naik on 27-12-2024.
 */
@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinsListState())
    val state: State<CoinsListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value =
                        CoinsListState(error = result.message ?: "Unexpected error occurred")
                }

                is Resource.Loading -> {
                    _state.value = CoinsListState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CoinsListState(coins = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }
}