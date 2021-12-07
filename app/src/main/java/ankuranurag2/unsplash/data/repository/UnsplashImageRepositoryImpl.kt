package ankuranurag2.unsplash.data.repository

import ankuranurag2.unsplash.data.models.ImageData
import ankuranurag2.unsplash.data.remote.UnsplashApi
import ankuranurag2.unsplash.domain.repository.UnsplashImageRepository
import ankuranurag2.unsplash.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UnsplashImageRepositoryImpl @Inject constructor(
    private val api: UnsplashApi
) : UnsplashImageRepository {

    override fun getImages(accessKey: String, pageNum: Int)
            : Flow<Resource<List<ImageData>>> = flow {

        emit(Resource.Loading<List<ImageData>>())

        try {
            val imageList = api.getUnsplashImages(accessKey, pageNum)
            emit(Resource.Success<List<ImageData>>(data = imageList.map { it.toImageData() }))
        } catch (e: HttpException) {
            emit(Resource.Error<List<ImageData>>("Oops, Something went wrong!"))
        } catch (e: IOException) {
            emit(Resource.Error<List<ImageData>>("Please check you internet connection!"))
        }
    }
}