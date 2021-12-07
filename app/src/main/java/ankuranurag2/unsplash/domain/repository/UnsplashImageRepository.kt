package ankuranurag2.unsplash.domain.repository

import ankuranurag2.unsplash.data.models.ImageDto

interface UnsplashImageRepository {
    suspend fun getImages(accessKey: String, pageNum: Int): List<ImageDto>
}