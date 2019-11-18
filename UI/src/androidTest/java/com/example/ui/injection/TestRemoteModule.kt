package com.example.ui.injection

import com.example.data.repository.CVRemote
import com.example.remote.service.CVService
import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides

@Module
object TestRemoteModule {

    @Provides
    @JvmStatic
    fun provideCVService(): CVService {
        return mock()
    }

    @Provides
    @JvmStatic
    fun provideCVRemote(): CVRemote {
        return mock()
    }
}