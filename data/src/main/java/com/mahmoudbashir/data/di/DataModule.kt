package com.mahmoudbashir.data.di

import com.mahmoudbashir.data.remote.ApiServer
import com.mahmoudbashir.data.repository.RemoteProductsRepoImp
import com.mahmoudbashir.data.utils.Constants
import com.mahmoudbashir.domain.repository.GetProductsRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule{

    @Provides
    @Singleton
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun getRetrofitInstance(BASE_URL:String): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    @Provides
    @Singleton
    fun getApiInterface(retrofit: Retrofit):ApiServer = retrofit.create(ApiServer::class.java)

    @Provides
    @Singleton
    fun getRepImp(repo: RemoteProductsRepoImp):GetProductsRepoImpl=repo
}