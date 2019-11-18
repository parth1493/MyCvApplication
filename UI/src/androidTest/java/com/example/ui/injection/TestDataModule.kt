package com.example.ui.injection

import com.example.domain.respository.CVRepository
import com.nhaarman.mockito_kotlin.mock
import dagger.Module

import dagger.Provides
import javax.inject.Singleton

@Module
object TestDataModule {

    @Provides
    @JvmStatic
    @Singleton
    fun provideDataRepository(): CVRepository {
        return mock()
    }
}