package com.mnaik.coinradar.data.repository

import com.mnaik.coinradar.data.remote.CoinApi
import com.mnaik.coinradar.data.remote.dto.tag.TagDetailDto
import com.mnaik.coinradar.data.remote.dto.tag.TagDto
import com.mnaik.coinradar.domain.repository.TagRepository
import javax.inject.Inject

/**
 *
 * Created by Monil Naik on 31-12-2024.
 */
class TagRepositoryImpl @Inject constructor(private val api: CoinApi) : TagRepository {
    override suspend fun getTags(): List<TagDto> {
        return api.getTags()
    }

    override suspend fun getTagById(tagId: String): TagDetailDto {
        return api.getTagById(tagId,"coins,icos")
    }
}
