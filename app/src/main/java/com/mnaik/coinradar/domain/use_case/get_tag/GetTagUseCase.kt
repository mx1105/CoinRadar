package com.mnaik.coinradar.domain.use_case.get_tag

import com.mnaik.coinradar.common.Resource
import com.mnaik.coinradar.data.remote.dto.tag.toTagDetail
import com.mnaik.coinradar.domain.model.TagDetail
import com.mnaik.coinradar.domain.repository.TagRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Monil Naik on 31-12-2024.
 */
class GetTagUseCase @Inject constructor(
    private val repository: TagRepository
) {

    operator fun invoke(tagId: String): Flow<Resource<TagDetail>> = flow {
        try {
            emit(Resource.Loading())
            val tags = repository.getTagById(tagId).toTagDetail()
            emit(Resource.Success(tags))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An Unexpected Error occurs"))
        } catch (e: IOException) {
            emit(Resource.Error("Please Check Your internet connection"))
        }
    }
}