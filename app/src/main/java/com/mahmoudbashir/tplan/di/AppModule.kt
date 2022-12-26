package com.mahmoudbashir.tplan.di

import com.mahmoudbashir.data.repository.RemoteProductsRepoImp
import com.mahmoudbashir.domain.usecases.GetProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun getUseCase(repo: RemoteProductsRepoImp):GetProductsUseCase = GetProductsUseCase(repo)
}