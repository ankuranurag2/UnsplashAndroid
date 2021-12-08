package ankuranurag2.unsplash.data.repository

import ankuranurag2.unsplash.data.local.ImageDao
import ankuranurag2.unsplash.data.models.ImageData
import ankuranurag2.unsplash.data.remote.UnsplashApi
import ankuranurag2.unsplash.domain.repository.UnsplashImageRepository
import ankuranurag2.unsplash.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.net.HttpURLConnection
import javax.inject.Inject

class UnsplashImageRepositoryImpl @Inject constructor(
    private val api: UnsplashApi,
    private val dao: ImageDao
) : UnsplashImageRepository {

    override fun getImages(accessKey: String, pageNum: Int)
            : Flow<Resource<List<ImageData>>> = flow {

        emit(Resource.Loading<List<ImageData>>())

        val cachedList = dao.fetchImagesForPage(pageNum)
        emit(Resource.Loading(data = cachedList))

        try {
            val imageList = api.getUnsplashImages(accessKey, pageNum)
            dao.addImages(imageList.map { it.toImageData().also { data -> data.pageNum = pageNum } })
        } catch (e: HttpException) {
            if (e.response()?.code() == HttpURLConnection.HTTP_UNAUTHORIZED)
                emit(Resource.Error<List<ImageData>>("Check your API Key"))
            else
                emit(Resource.Error<List<ImageData>>("Oops, Something went wrong!"))
        } catch (e: IOException) {
            emit(Resource.Error<List<ImageData>>("Please check you internet connection!"))
        }

        val newImages = dao.fetchImagesForPage(pageNum)
        emit(Resource.Success(data = newImages))
    }
}