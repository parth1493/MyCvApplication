package com.example.ui.injection

import android.app.Application
import com.example.cache.db.CVDatabase
import com.example.data.repository.CVCache
import com.nhaarman.mockito_kotlin.mock

import dagger.Module
import dagger.Provides


@Module
object TestCacheModule {

    @Provides
    @JvmStatic
    fun provideDatabase(application: Application): CVDatabase {
        return CVDatabase.getInstance(application)
    }

    @Provides
    @JvmStatic
    fun provideCVCache(): CVCache {
        return mock()
    }
}