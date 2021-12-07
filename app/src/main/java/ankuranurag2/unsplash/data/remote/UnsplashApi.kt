package ankuranurag2.unsplash.data.remote

import ankuranurag2.unsplash.data.models.ImageDto
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApi {

    @GET("/photos/")
    suspend fun getUnsplashImages(
        @Query("client_id") accessKey: String,
        @Query("page") page: Int,
    ): List<ImageDto>

    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
    }
}