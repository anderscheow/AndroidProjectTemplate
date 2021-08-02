package com.example.common.di

import android.app.Application
import androidx.work.WorkManager
import com.example.common.repository.auth_repository.AuthRepository
import com.example.common.repository.auth_repository.IAuthRepository
import com.example.common.repository.auth_repository.remote.AuthApi
import com.example.common.repository.system_repository.ISystemRepository
import com.example.common.repository.system_repository.SystemRepository
import com.example.common.repository.system_repository.remote.SystemApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideSystemApi(retrofit: Retrofit): SystemApi = retrofit.create(SystemApi::class.java)

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthApi = retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideAuthRepository(repository: AuthRepository): IAuthRepository = repository

    @Provides
    @Singleton
    fun provideSystemRepository(repository: SystemRepository): ISystemRepository = repository

    @Provides
    @Singleton
    fun provideWorkManager(application: Application): WorkManager {
        return WorkManager.getInstance(application)
    }
}