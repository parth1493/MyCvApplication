package com.example.ui.injection.module

import com.example.domain.executor.PostExecutionThread
import com.example.ui.UiThread
import com.example.ui.view.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiModule {
    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @ContributesAndroidInjector
    abstract fun contributesProfile(): MainActivity

//    @ContributesAndroidInjector
//    abstract fun contributesSkill(): SkillFragment
//
//
//    @ContributesAndroidInjector
//    abstract fun contributesTimeline(): WorkFragment
}