package ankuranurag2.unsplash.domain.repository

import ankuranurag2.unsplash.data.models.ImageData
import ankuranurag2.unsplash.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UnsplashImageRepository {
    fun getImages(accessKey: String, pageNum: Int): Flow<Resource<List<ImageData>>>
}