package com.example.resourceconvertersample.login.di.login

import com.example.resourceconvertersample.login.model.LoginRepository
import com.example.resourceconvertersample.login.model.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object LoginModule {

    @Provides
    fun provideLoginUseCase(
        repository: LoginRepository
    ): LoginUseCase {
        return LoginUseCase(repository)
    }
}