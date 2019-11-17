package com.example.ui.injection.module

import com.example.data.repository.CVRemote
import com.example.remote.CVRemoteImpl
import com.example.remote.service.CVService
import com.example.remote.service.CVServiceFactory
import com.example.ui.BuildConfig
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RemoteModule {
    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideCVService(): CVService {
            return CVServiceFactory.makeGithubTrendingService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindCVRemote(cvRemoteImpl: CVRemoteImpl): CVRemote
}