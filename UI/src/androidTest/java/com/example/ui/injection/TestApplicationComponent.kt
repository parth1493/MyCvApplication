package com.example.ui.injection

import android.app.Application
import com.example.domain.respository.CVRepository
import com.example.ui.injection.module.PresentationModule
import com.example.ui.injection.module.UiModule
import com.example.ui.test.factory.TestApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Component (modules = arrayOf(AndroidInjectionModule::class,
    TestApplicationModule::class,
    TestCacheModule::class,
    TestDataModule::class,
    PresentationModule::class,
    UiModule::class,
    TestRemoteModule::class))
@Singleton
interface TestApplicationComponent {

    fun cvRepository(): CVRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): TestApplicationComponent.Builder

        fun build(): TestApplicationComponent
    }

    fun inject(app: TestApplication)

}