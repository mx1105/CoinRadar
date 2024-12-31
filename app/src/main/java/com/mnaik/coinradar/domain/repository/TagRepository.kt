package com.mnaik.coinradar.domain.repository

import com.mnaik.coinradar.data.remote.dto.tag.TagDetailDto
import com.mnaik.coinradar.data.remote.dto.tag.TagDto

/**
 * Created by Monil Naik on 31-12-2024.
 */
interface TagRepository {

    suspend fun getTags(): List<TagDto>

    suspend fun getTagById(tagId: String): TagDetailDto
}