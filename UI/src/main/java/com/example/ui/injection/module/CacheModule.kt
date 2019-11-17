package com.example.ui.injection.module

import android.app.Application
import com.example.cache.CVCachedImpl
import com.example.cache.db.CVDatabase
import com.example.data.repository.CVCache

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class CacheModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun providesDataBase(application: Application): CVDatabase {
            return CVDatabase.getInstance(application)
        }
    }

    @Binds
    abstract fun bindProjectsCache(cvCache: CVCachedImpl): CVCache
}