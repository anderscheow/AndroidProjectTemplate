package com.example.lib_data_source

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.example.lib_data_source.network.ApiConstant
import com.example.lib_data_source.network.NetworkAuthenticator
import com.example.lib_data_source.network.NetworkInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        interceptors: MutableList<Interceptor>,
        authenticator: NetworkAuthenticator
    ): OkHttpClient {
        val builder = Builder()
        interceptors.forEach {
            builder.addInterceptor(it)
        }
        builder.authenticator(authenticator)
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideInterceptors(
        networkInterceptor: NetworkInterceptor,
    ): MutableList<Interceptor> {
        val list = mutableListOf<Interceptor>()
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
                this.setLevel(HttpLoggingInterceptor.Level.BODY)
            }
            list.add(httpLoggingInterceptor)
        }
        list.add(networkInterceptor)
        return list
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstant.APP_DOMAIN)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }


}