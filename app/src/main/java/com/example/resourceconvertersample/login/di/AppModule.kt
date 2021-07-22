package com.example.resourceconvertersample.login.di

import com.example.resourceconvertersample.login.data.LoginRepositoryImpl
import com.example.resourceconvertersample.login.model.LoginRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideLoginRepository(): LoginRepository {
        return LoginRepositoryImpl()
    }
}