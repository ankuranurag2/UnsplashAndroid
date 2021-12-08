package ankuranurag2.unsplash.di

import android.app.Application
import androidx.room.Room
import ankuranurag2.unsplash.data.local.ImageDatabase
import ankuranurag2.unsplash.data.remote.UnsplashApi
import ankuranurag2.unsplash.data.repository.AccessKeyRepositoryImpl
import ankuranurag2.unsplash.data.repository.UnsplashImageRepositoryImpl
import ankuranurag2.unsplash.domain.repository.AccessKeyRepository
import ankuranurag2.unsplash.domain.repository.UnsplashImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModules {

    @Provides
    @Singleton
    fun provideUnsplashApi(): UnsplashApi {
        return Retrofit.Builder()
            .baseUrl(UnsplashApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UnsplashApi::class.java)
    }

    @Provides
    @Singleton
    fun provideImageRepository(api: UnsplashApi, db: ImageDatabase): UnsplashImageRepository {
        return UnsplashImageRepositoryImpl(api, db.getDao())
    }

    @Provides
    @Singleton
    fun provideKeyRepository(): AccessKeyRepository {
        return AccessKeyRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): ImageDatabase {
        return Room
            .databaseBuilder(app, ImageDatabase::class.java, "img_db")
            .build()
    }
}