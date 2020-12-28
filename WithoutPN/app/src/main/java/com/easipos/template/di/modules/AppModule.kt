package com.easipos.template.di.modules

import android.app.Application
import androidx.room.Room
import com.easipos.template.Easi
import com.easipos.template.api.misc.AuthInterceptor
import com.easipos.template.api.misc.HostSelectionInterceptor
import com.easipos.template.api.misc.TokenAuthenticator
import com.easipos.template.api.misc.constructOkhttpClient
import com.easipos.template.api.services.Api
import com.easipos.template.datasource.DataFactory
import com.easipos.template.repositories.precheck.PrecheckDataRepository
import com.easipos.template.repositories.precheck.PrecheckRepository
import com.easipos.template.room.RoomService
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import io.github.anderscheow.library.di.modules.BaseModule
import io.github.anderscheow.library.di.modules.CommonBaseModule
import io.github.anderscheow.validator.Validator
import org.kodein.di.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CommonModule(private val easi: Easi) : CommonBaseModule() {
    override fun provideAdditionalModule(builder: DI.Builder) {
        builder.apply {
            bind<Easi>() with singleton { instance<Application>() as Easi }
            bind<Validator>() with singleton { Validator.with(easi) }

            bind<DataFactory>() with singleton {
                DataFactory(instance(), instance())
            }

            bind<PrecheckRepository>() with singleton { PrecheckDataRepository(instance()) }
        }
    }
}

class ApiModule(private val userAgent: String,
                private val endpoint: String,
                private val authorisation: String
) : BaseModule("apiModule") {
    override fun provideAdditionalModule(builder: DI.Builder) {
        builder.apply {
            bind<AuthInterceptor>() with singleton { AuthInterceptor(userAgent, authorisation) }
            bind<HostSelectionInterceptor>() with singleton { HostSelectionInterceptor() }
            bind<TokenAuthenticator>() with singleton { TokenAuthenticator(instance()) }
            bind<RxJava2CallAdapterFactory>() with singleton { RxJava2CallAdapterFactory.create() }
            bind<GsonConverterFactory>() with singleton {
                val gson = GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                    .create()
                GsonConverterFactory.create(gson)
            }
            bind<Api>() with singleton {
                Retrofit.Builder()
                    .baseUrl(endpoint)
                    .client(constructOkhttpClient(listOf(
                        instance<AuthInterceptor>(), instance<HostSelectionInterceptor>()
                    ), instance<TokenAuthenticator>()))
                    .addCallAdapterFactory(instance())
                    .addConverterFactory(instance())
                    .build()
                    .create(Api::class.java)
            }
        }
    }
}

class DatabaseModule(private val easi: Easi,
                     private val dbName: String
) : BaseModule("databaseModule") {
    override fun provideAdditionalModule(builder: DI.Builder) {
        builder.apply {
            bind<RoomService>() with eagerSingleton {
                Room.databaseBuilder(easi.applicationContext,
                    RoomService::class.java, dbName)
                    .fallbackToDestructiveMigration()
                    .build()
            }
        }
    }
}