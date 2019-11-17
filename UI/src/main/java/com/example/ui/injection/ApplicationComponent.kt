package com.example.ui.injection

import android.app.Application
import com.example.ui.CVApplication
import com.example.ui.injection.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Component (modules = arrayOf(AndroidInjectionModule::class,
    ApplicationModule::class,
    UiModule::class,
    PresentationModule::class,
    DataModule::class,
    CacheModule::class,
    RemoteModule::class))
@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application : Application):Builder

        fun build():ApplicationComponent
    }
    fun inject(app: CVApplication)
}