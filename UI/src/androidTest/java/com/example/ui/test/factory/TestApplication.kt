package com.example.ui.test.factory

import android.app.Application
import androidx.test.platform.app.InstrumentationRegistry
import com.example.ui.injection.DaggerTestApplicationComponent
import com.example.ui.injection.TestApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class TestApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>
    private lateinit var appComponent: TestApplicationComponent

    companion object {
        fun appComponent(): TestApplicationComponent {
            return (InstrumentationRegistry.getInstrumentation().targetContext
                    as TestApplication).appComponent
        }
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerTestApplicationComponent.builder().application(this).build()
        appComponent.inject(this)

    }
}