package ankuranurag2.unsplash.data.repository

import ankuranurag2.unsplash.data.models.ImageDto
import ankuranurag2.unsplash.data.remote.UnsplashApi
import ankuranurag2.unsplash.domain.repository.UnsplashImageRepository
import javax.inject.Inject

class UnsplashImageRepositoryImpl @Inject constructor(
    private val api: UnsplashApi
) : UnsplashImageRepository {
    override suspend fun getImages(accessKey: String, pageNum: Int): List<ImageDto> {
        return api.getUnsplashImages(accessKey, pageNum)
    }
}