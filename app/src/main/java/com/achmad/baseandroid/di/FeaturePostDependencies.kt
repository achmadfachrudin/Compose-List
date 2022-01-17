package com.achmad.baseandroid.di

import android.content.SharedPreferences
import com.achmad.baseandroid.cache.PostDao
import com.achmad.baseandroid.service.PostRemote
import com.achmad.baseandroid.service.PostRepository
import com.achmad.baseandroid.service.PostService
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FeaturePostDependencies {

    fun sharedPreferences(): SharedPreferences
    fun postRepository(): PostRepository
    fun postService(): PostService
    fun postRemote(): PostRemote
    fun postDao(): PostDao
}
