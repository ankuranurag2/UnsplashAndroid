package ankuranurag2.unsplash.domain.usecases

import ankuranurag2.unsplash.data.models.ImageData
import ankuranurag2.unsplash.domain.repository.UnsplashImageRepository
import ankuranurag2.unsplash.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(
    private val repository: UnsplashImageRepository
) {

    operator fun invoke(params: Param): Flow<Resource<List<ImageData>>> = flow {
        repository.getImages(params.accessKey, params.pageNum)
    }

    data class Param(
        val accessKey: String,
        val pageNum: Int
    )
}