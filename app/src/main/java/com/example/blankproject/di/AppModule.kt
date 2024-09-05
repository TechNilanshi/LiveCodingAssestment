package com.example.blankproject.di

import com.example.blankproject.data.remote.UserApi
import com.example.blankproject.data.repository.GetUserListRepository
import com.example.blankproject.domain.usecase.GetUserListUseCaseImpl
import com.example.blankproject.presentation.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideUserRepository(userListRepository: GetUserListRepository): GetUserListUseCaseImpl {
        return GetUserListUseCaseImpl(userListRepository)
    }

    @Singleton
    @Provides
    fun injectRetrofitApi(): UserApi {

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApi::class.java)
    }
}