package com.example.lib_data_source

import android.content.Context
import androidx.room.Room
import com.example.lib_data_source.preference.AppSharedPreference
import com.example.lib_data_source.preference.IAppSharedPreference
import com.example.lib_data_source.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PersistenceModule {

    @Provides
    @Singleton
    internal fun provideDb(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "AppConstant.DB_NAME")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideSharedPreference(@ApplicationContext context: Context): IAppSharedPreference {
        return AppSharedPreference(context)
    }
}