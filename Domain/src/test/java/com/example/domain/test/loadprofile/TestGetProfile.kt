package com.example.domain.test.loadprofile

import com.example.domain.executor.PostExecutionThread
import com.example.domain.fakedata.ProfileFakeDataFactory
import com.example.domain.interactor.loadprofile.GetProfile
import com.example.domain.model.Profile
import com.example.domain.respository.CVRepository
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class TestGetProfile {
    private lateinit var getProfile: GetProfile
    @Mock lateinit var cvRepository: CVRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getProfile = GetProfile(cvRepository, postExecutionThread)
    }

    @Test
    fun getProfilesCompletes() {
        stubGetProjects(Observable.just(ProfileFakeDataFactory.makeProfileList(2)))
        val testObserver = getProfile.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProfileReturnsData() {
        val projects = ProfileFakeDataFactory.makeProfileList(2)
        stubGetProjects(Observable.just(projects))
        val testObserver = getProfile.buildUseCaseObservable().test()
        testObserver.assertValue(projects)
    }

    private fun stubGetProjects(observable: Observable<List<Profile>>) {
        whenever(cvRepository.getProfile())
            .thenReturn(observable)
    }
}