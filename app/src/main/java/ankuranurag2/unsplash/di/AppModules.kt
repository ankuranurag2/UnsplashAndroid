package ankuranurag2.unsplash.di

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
    fun provideImageRepository(api: UnsplashApi): UnsplashImageRepository {
        return UnsplashImageRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideKeyRepository(): AccessKeyRepository {
        return AccessKeyRepositoryImpl()
    }
}