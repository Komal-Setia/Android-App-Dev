package com.example.dialogflix.di

import com.example.dialogflix.api.DialogFlixAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideDialogFlixApi(retrofit: Retrofit) : DialogFlixAPI{
        return retrofit.create(DialogFlixAPI::class.java)
    }
}