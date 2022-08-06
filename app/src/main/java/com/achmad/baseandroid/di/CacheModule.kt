package com.achmad.baseandroid.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.achmad.baseandroid.cache.AppDatabase
import com.achmad.baseandroid.cache.PostDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("preferences_name", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application
    ): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "baseandroid.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePostDao(appDatabase: AppDatabase): PostDao {
        return appDatabase.postDao()
    }
}
