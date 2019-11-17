package com.example.ui.injection.module

import com.example.data.CVDataRepository
import com.example.domain.respository.CVRepository
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {
    @Binds
    abstract fun bindDataRepository(dataRepository: CVDataRepository):CVRepository
}