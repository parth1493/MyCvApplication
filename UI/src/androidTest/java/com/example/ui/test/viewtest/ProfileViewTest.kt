package com.example.ui.test.viewtest

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.domain.model.Profile
import com.example.ui.test.factory.TestApplication
import com.example.ui.test.factory.TestUIFactory
import com.example.ui.view.MainActivity
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProfileViewTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)

    @Test
    fun activityLaunches() {
        stubRepositoryGetProfile(Observable.just(listOf(TestUIFactory.makeProfile())))
        activity.launchActivity(null)
    }

    private fun stubRepositoryGetProfile(observable: Observable<List<Profile>>) {
        whenever(TestApplication.appComponent().cvRepository().getProfile())
            .thenReturn(observable)
    }
}