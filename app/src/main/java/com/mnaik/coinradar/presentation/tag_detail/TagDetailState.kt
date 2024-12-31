package com.mnaik.coinradar.presentation.tag_detail

import com.mnaik.coinradar.domain.model.TagDetail

/**
 * Created by Monil Naik on 31-12-2024.
 */
data class TagDetailState(
    val isLoading: Boolean = false, val tag: TagDetail? = null, val error: String = ""
)