package com.mnaik.coinradar.presentation.tag_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnaik.coinradar.common.Constants
import com.mnaik.coinradar.common.Resource
import com.mnaik.coinradar.domain.use_case.get_tag.GetTagUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Monil Naik on 31-12-2024.
 */
@HiltViewModel
class TagDetailViewModel @Inject constructor(
    private val getTagUseCase: GetTagUseCase, private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(TagDetailState())
    val state: State<TagDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_TAG_ID)?.let { tagId ->
            getTags(tagId)
        }
    }

    private fun getTags(tagId: String) {
        getTagUseCase(tagId).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value =
                        TagDetailState(error = result.message ?: "Unexpected error occurred")
                }

                is Resource.Loading -> {
                    _state.value = TagDetailState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = TagDetailState(tag = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}